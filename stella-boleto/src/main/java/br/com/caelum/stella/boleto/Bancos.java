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
		
		// TODO: em vez de replace, setar na enesima posicao ataves do builder
		codigoDeBarras = codigoDeBarras.replace('D', Character.forDigit(
				geraDVCodigoDeBarras(codigoDeBarras), 10));

		return codigoDeBarras;
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
		return null;
		/*
		 * return calculaCampo1(boleto).substring(0, 5) + "." +
		 * calculaCampo1(boleto).substring(5) + " " +
		 * calculaCampo2(boleto).substring(0, 5) + "." +
		 * calculaCampo2(boleto).substring(5) + " " +
		 * calculaCampo3(boleto).substring(0, 5) + "." +
		 * calculaCampo3(boleto).substring(5) + " " + calculaCampo4(boleto) + " " +
		 * calculaCampo5(boleto);
		 */
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
