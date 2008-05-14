package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;

/**
 * 
 * @see http://stella.caelum.com.br/boleto-setup.html
 * 
 * @author Cauê Guerra
 * @author Guilherme Silveira
 * 
 */
public class BancoDoBrasil implements Banco {

	private static final String NUMERO_BB = "001";

	private final DVGenerator dvGenerator = new DVGenerator();

	public BancoDoBrasil() {

	}

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado());
		builder.append(String.valueOf(boleto.getCodEspecieMoeda()));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());

		// CAMPO LIVRE
		builder.append("000000");
		builder.append(boleto.getEmissor().getNumConvenioFormatado());
		builder.append(boleto.getEmissor().getNossoNumeroFormatado());
		builder.append(boleto.getEmissor().getCarteira());

		String codigoDeBarras = builder.toString();
		builder.replace(4, 5, String.valueOf(this.dvGenerator
				.geraDVCodigoDeBarras(codigoDeBarras)));

		return builder.toString();
	}

	public String geraLinhaDigitavelPara(Boleto boleto) {
		String codigoDeBarras = geraCodigoDeBarrasPara(boleto);

		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado());
		builder.append(String.valueOf(boleto.getCodEspecieMoeda()));
		builder.append(codigoDeBarras.substring(19, 24));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.substring(24, 34));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.substring(34, 44));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.charAt(4));
		builder.append(codigoDeBarras.substring(5, 9));
		builder.append(boleto.getValorFormatado());

		String linhaDigitavel = builder.toString();
		builder.replace(9, 10, String.valueOf(this.dvGenerator
				.geraDVLinhaDigitavel(linhaDigitavel.substring(0, 9))));
		builder.replace(20, 21, String.valueOf(this.dvGenerator
				.geraDVLinhaDigitavel(linhaDigitavel.substring(10, 20))));
		builder.replace(31, 32, String.valueOf(this.dvGenerator
				.geraDVLinhaDigitavel(linhaDigitavel.substring(21, 31))));

		builder.insert(5, '.');
		builder.insert(11, "  ");
		builder.insert(18, '.');
		builder.insert(25, "  ");
		builder.insert(32, '.');
		builder.insert(39, "  ");
		builder.insert(42, "  ");

		return builder.toString();
	}

	public String getNumeroFormatado() {
		return NUMERO_BB;
	}

	public java.net.URL getImage() {
		return getClass().getResource(
				String.format("/br/com/caelum/stella/boleto/img/%s.png",
						getNumeroFormatado()));
	}

}
