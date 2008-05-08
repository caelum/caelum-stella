package br.com.caelum.stella.boleto;


public class BancoDoBrasil implements Banco {
	
	private int numero = 1;

	public int getNumero() {
		return this.numero;
	}

	public String getNumeroFormatado() {
		return String.format("%03d", this.numero);
	}

	public java.net.URL getImage() {
		return Bancos.class.getResource(String
				.format("/br/com/caelum/stella/boleto/img/%s.png",
						getNumeroFormatado()));
	}

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getNumeroFormatado());
		builder.append(String.valueOf(boleto.getCodEspecieMoeda()));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());
		builder.append("000000");
		builder.append(boleto.getEmissor().getNumConvenio());
		builder.append(boleto.getEmissor().getNossoNumero());
		builder.append(boleto.getEmissor().getCarteira());
		
		String codigoDeBarras = builder.toString();
		builder.replace(4, 5, String.valueOf(geraDVCodigoDeBarras(codigoDeBarras)));

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
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());
		
		String linhaDigitavel = builder.toString();
		builder.replace(9, 10, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(0, 9))));
		builder.replace(20, 21, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(10, 20))));
		builder.replace(31, 32, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(21, 31))));
		
		builder.insert(5, '.');
		builder.insert(11, "  ");
		builder.insert(18, '.');
		builder.insert(25, "  ");
		builder.insert(32, '.');
		builder.insert(39, "  ");
		builder.insert(42, "  ");
		
		return builder.toString();
	}

	public int geraDVCodigoDeBarras(String codigoDeBarras) {
		int soma = 0;
		for (int i = 0, multiplicador = 2; i < codigoDeBarras.length(); i++, multiplicador++) {
			if (i == 4) // pula posição 5
				i++;
			if (multiplicador == 10) // volta pro 2
				multiplicador = 2;
			soma += Integer.parseInt(String.valueOf(codigoDeBarras.charAt(i)))
					* multiplicador;
		}

		int resto = soma % 11;
		return 11 - resto;
	}

	public int geraDVLinhaDigitavel(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo.charAt(i))) * multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}
		
		int resto = soma % 10;
		return 10 - resto;
	}
	
}
