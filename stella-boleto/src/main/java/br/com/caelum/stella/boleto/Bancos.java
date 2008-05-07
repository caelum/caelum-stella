package br.com.caelum.stella.boleto;

/**
 * Define a implementação dos Bancos no modo geral.
 * 
 * Documentação que pode ser consultada:
 * 
 * http://www.macoratti.net/boleto.htm
 * http://pt.wikipedia.org/wiki/Boleto_bancário
 * 
 * Manual oficial da Febraban:
 * http://www.bradesco.com.br/br/pj/conteudo/sol_rec/pdf/manualtecnico.pdf
 * 
 * Para testes rapidos: http://evandro.net/codigo_barras.html
 * 
 * Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com
 * valores e testar alguns boletos, em especial se valores serão altos.
 * 
 * @author Paulo Silveira
 * 
 */
public enum Bancos implements Banco {
	BANCO_DO_BRASIL(1), BRADESCO(237), ITAU(341), BANCO_REAL(356), CAIXA_ECONOMICA(
			104), UNIBANCO(409), HSBC(399);

	private int numero;

	private Bancos(int numero) {
		this.numero = numero;
	}

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado());
		builder.append(String.valueOf(boleto.getCodEspecieMoeda()));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());
		builder.append(boleto.getEmissor().getAgencia());
		builder.append(boleto.getEmissor().getCarteira());
		builder.append(boleto.getEmissor().getNossoNumero());
		builder.append(boleto.getEmissor().getContaCorrente());
		builder.append("0"); // zero fixo
		
		String codigoDeBarras = builder.toString();
		builder.replace(4, 5, String.valueOf(geraDVCodigoDeBarras(codigoDeBarras)));

		return builder.toString();
	}

	int geraDVCodigoDeBarras(String codigoDeBarras) {
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

	public String geraLinhaDigitavelPara(Boleto boleto) {
		String codigoDeBarras = this.geraCodigoDeBarrasPara(boleto);
		
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
		builder.append(String.valueOf(boleto.getFatorVencimento()));
		builder.append(boleto.getValorFormatado());
		
		String linhaDigitavel = builder.toString();
		builder.replace(9, 10, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(0, 9))));
		builder.replace(20, 21, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(10, 20))));
		builder.replace(31, 32, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(21, 31))));

		return builder.toString();
	}
	
	private int geraDVLinhaDigitavel(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo.charAt(i))) * multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}
		
		int resto = soma % 10;
		return 10 - resto;
	}

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

}
