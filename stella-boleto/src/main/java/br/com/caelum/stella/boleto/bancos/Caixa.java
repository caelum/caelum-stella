package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;
import static java.lang.String.format;

public class Caixa extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;


	private static final String NUMERO_CAIXA = "104";
	private static final String DIGITO_CAIXA = "0";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		
		Emissor emissor = boleto.getEmissor();
		String carteiraDoEmissor = emissor.getCarteira();
		StringBuilder campoLivre = new StringBuilder();
		
		if (carteiraDoEmissor.equals("1")) {
			campoLivre.append(carteiraDoEmissor);
			campoLivre.append(leftPadWithZeros(emissor.getContaCorrente(), 6));
			campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
		}
		else if (carteiraDoEmissor.equals("2")) {
			String nossoNumeroCompleto = getNossoNumeroDoEmissorFormatado(emissor);
			campoLivre.append(leftPadWithZeros(emissor.getContaCorrente(), 6));
			campoLivre.append(emissor.getDigitoContaCorrente());
			campoLivre.append(nossoNumeroCompleto.substring(2, 5));
			campoLivre.append(nossoNumeroCompleto.substring(0, 1));
			campoLivre.append(nossoNumeroCompleto.substring(5 ,8));
			campoLivre.append(nossoNumeroCompleto.substring(1, 2));
			campoLivre.append(nossoNumeroCompleto.substring(8));
			campoLivre.append(geradorDeDigito.geraDigitoMod11(campoLivre.toString()));
		}
		else {
			throw new IllegalArgumentException("A carteira digitada não é suportada: " + carteiraDoEmissor);
		}
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_CAIXA).toString();
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getCarteira(), 2);
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getContaCorrente(), 5);
	}

	public String getCodigoOperacaoFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getCodigoOperacao(), 3);
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getNossoNumero(), 17);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_CAIXA;
	}
	
	@Override
	public String getNossoNumeroECodDocumento(Boleto boleto) {
		
		Emissor emissor = boleto.getEmissor();
		
		String nn = getNossoNumeroDoEmissorFormatado(emissor);
		StringBuilder builder = new StringBuilder(nn);
		
		if(emissor.getDigitoNossoNumero() != null 
				&& !emissor.getDigitoNossoNumero().isEmpty()){
			builder.append("-").append(emissor.getDigitoNossoNumero());
		}
		return builder.toString();
	}
}
