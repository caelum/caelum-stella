package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;

public class Caixa extends AbstractBanco implements Banco {

	private static final String NUMERO_CAIXA = "104";
	private static final String DIGITO_CAIXA = "0";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		
		Emissor emissor = boleto.getEmissor();
		int carteiraDoEmissor = emissor.getCarteira();
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());
		
		if (carteiraDoEmissor == 1) {
			codigoDeBarras.append(carteiraDoEmissor);
			codigoDeBarras.append(String.format("%06d", emissor.getContaCorrente()));
			codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
		}
		else if (carteiraDoEmissor == 2) {
			String nossoNumeroCompleto = getNossoNumeroDoEmissorFormatado(emissor);
			codigoDeBarras.append(String.format("%06d", emissor.getContaCorrente()));
			codigoDeBarras.append(emissor.getDigitoContaCorrente());
			codigoDeBarras.append(nossoNumeroCompleto.substring(2, 5));
			codigoDeBarras.append(nossoNumeroCompleto.substring(0, 1));
			codigoDeBarras.append(nossoNumeroCompleto.substring(5 ,8));
			codigoDeBarras.append(nossoNumeroCompleto.substring(1, 2));
			codigoDeBarras.append(nossoNumeroCompleto.substring(8));
			codigoDeBarras.append(dvGenerator.geraDigitoMod11(codigoDeBarras.substring(18)));
		}
		else {
			throw new IllegalArgumentException("A carteira digitada não é suportada");
		}
		
		codigoDeBarras.insert(4, dvGenerator.geraDigitoMod11(codigoDeBarras.toString()));
		return codigoDeBarras.toString();
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_CAIXA).toString();
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%02d", emissor.getCarteira());
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%05d", emissor.getContaCorrente());
	}
	
	public String getCodigoFornecidoPelaAgenciaFormatado(Emissor emissor) {
		return String.format("%08d", emissor.getCodigoFornecidoPelaAgencia());
	}

	public String getCodigoOperacaoFormatado(Emissor emissor) {
		return String.format("%03d", emissor.getCodigoOperacao());
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return String.format("%017d", emissor.getNossoNumero());
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_CAIXA;
	}
	
	@Override
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		
		String nn = getNossoNumeroDoEmissorFormatado(emissor);
		StringBuilder builder = new StringBuilder(nn);
		
		if(emissor.getDigitoNossoNumero() != null 
				&& !emissor.getDigitoNossoNumero().isEmpty()){
			builder.append("-").append(emissor.getDigitoNossoNumero());
		}
		return builder.toString();
	}
}
