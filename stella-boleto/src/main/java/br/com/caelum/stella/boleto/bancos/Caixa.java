package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;
import static java.lang.String.format;

public class Caixa extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_CAIXA = "104";
	private static final String DIGITO_CAIXA = "0";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {

		Beneficiario beneficiario = boleto.getBeneficiario();
		String carteiraDoEmissor = beneficiario.getCarteira();
		StringBuilder campoLivre = new StringBuilder();

		if (carteiraDoEmissor.equals("1")) {
			campoLivre.append(carteiraDoEmissor);
			campoLivre.append(leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 6));
			campoLivre.append(getNossoNumeroFormatado(beneficiario));
		} else if (carteiraDoEmissor.equals("2")) {
			String nossoNumeroCompleto = getNossoNumeroFormatado(beneficiario);
			campoLivre.append(leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 6));
			campoLivre.append(beneficiario.getDigitoCodigoBeneficiario());
			campoLivre.append(nossoNumeroCompleto.substring(2, 5));
			campoLivre.append(nossoNumeroCompleto.substring(0, 1));
			campoLivre.append(nossoNumeroCompleto.substring(5, 8));
			campoLivre.append(nossoNumeroCompleto.substring(1, 2));
			campoLivre.append(nossoNumeroCompleto.substring(8));
			campoLivre.append(geradorDeDigito.geraDigitoMod11(campoLivre.toString()));
		} else if (carteiraDoEmissor.equals("24")) {
			String nossoNumeroCompleto = getNossoNumeroFormatado(beneficiario);
			campoLivre.append(leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 6));
			campoLivre.append(beneficiario.getDigitoCodigoBeneficiario());
			campoLivre.append(nossoNumeroCompleto.substring(2, 5));
			campoLivre.append(nossoNumeroCompleto.substring(0, 1));
			campoLivre.append(nossoNumeroCompleto.substring(5, 8));
			campoLivre.append(nossoNumeroCompleto.substring(1, 2));
			campoLivre.append(nossoNumeroCompleto.substring(8));
			campoLivre.append(geradorDeDigito.geraDigitoMod11AceitandoRestoZero(campoLivre.toString()));
		} else {
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
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(), 2);
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 5);
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getNossoNumero(), 17);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_CAIXA;
	}

	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {

		Beneficiario beneficiario = boleto.getBeneficiario();

		String nn = getNossoNumeroFormatado(beneficiario);
		StringBuilder builder = new StringBuilder(nn);

		if (beneficiario.getDigitoNossoNumero() != null
				&& !beneficiario.getDigitoNossoNumero().isEmpty()) {
			builder.append("-").append(beneficiario.getDigitoNossoNumero());
		}
		return builder.toString();
	}
}
