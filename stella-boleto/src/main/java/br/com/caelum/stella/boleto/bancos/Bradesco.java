package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Boleto;

public class Bradesco extends AbstractBanco {

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getNumeroFormatado());
		builder.append(String.valueOf(boleto.getCodEspecieMoeda()));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());

		// CAMPO LIVRE
		builder.append(boleto.getEmissor().getAgencia());
		builder.append(boleto.getEmissor().getCarteira());
		builder.append(boleto.getEmissor().getNossoNumero());
		builder.append(boleto.getEmissor().getContaCorrenteFormatado());
		builder.append("0");

		String codigoDeBarras = builder.toString();
		builder.replace(4, 5, String
				.valueOf(geraDVCodigoDeBarras(codigoDeBarras)));

		return builder.toString();
	}

	public String geraLinhaDigitavelPara(Boleto boleto) {
		String codigoDeBarras = this.geraCodigoDeBarrasPara(boleto);

		StringBuilder builder = new StringBuilder();
		builder.append(this.getNumeroFormatado());
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
		builder.replace(9, 10, String
				.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(0, 9))));
		builder.replace(20, 21,
				String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(
						10, 20))));
		builder.replace(31, 32,
				String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(
						21, 31))));

		builder.insert(5, '.');
		builder.insert(11, "  ");
		builder.insert(18, '.');
		builder.insert(25, "  ");
		builder.insert(32, '.');
		builder.insert(39, "  ");
		builder.insert(42, "  ");

		return builder.toString();
	}

	public int getNumero() {
		return 237;
	}
}
