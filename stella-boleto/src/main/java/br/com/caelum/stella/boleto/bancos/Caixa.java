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
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());
		codigoDeBarras.append(emissor.getCarteira());
		codigoDeBarras.append(String.format("%06d", emissor.getContaCorrente()));
		codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
		codigoDeBarras.insert(4, this.dvGenerator.geraDigitoMod11(codigoDeBarras.toString()));
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
}
