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
 * Para testes rapidos:
 * http://evandro.net/codigo_barras.html
 * 
 * Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com valores
 * e testar alguns boletos, em especial se valores serão altos.
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
		builder.append(boleto.getCodEspecieMoeda());
		builder.append(calculaCampo4(boleto));

		return getNumeroFormatado() + String.valueOf(boleto.getCodEspecieMoeda())
				+ getCampo4(boleto) + String.valueOf(getCampo5()) + "9"
				+ boleto.getEmissor().getNossoNumero() + "00000" + boleto.getEmissor().getNossoNumero()
				+ boleto.getIOS() + boleto.getEmissor().getCarteira();
	}

	public String geraLinhaDigitavelPara(Boleto boleto) {
		return calculaCampo1(boleto).substring(0, 5) + "."
				+ calculaCampo1(boleto).substring(5) + "  "
				+ calculaCampo2(boleto).substring(0, 5) + "."
				+ calculaCampo2(boleto).substring(5) + "  "
				+ calculaCampo3(boleto).substring(0, 5) + "."
				+ calculaCampo3(boleto).substring(5) + "  "
				+ calculaCampo4(boleto) + "  " + calculaCampo5(boleto);
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
		
	
	/*
	 * Metodos privados auxiliares para calcular os campos!
	 */

	String calculaCampo1(Boleto boleto) {
		String campo = getNumero() + String.valueOf(boleto.getMoeda())
				+ boleto.getCodCliente().substring(0, 4);

		return boleto.getDigitoCampo(campo, 2);
	}

	String calculaCampo2(Boleto boleto) {
		String campo = boleto.getCodCliente().substring(4)
				+ boleto.getNossoNumero().substring(0, 7);

		return boleto.getDigitoCampo(campo, 1);
	}

	String calculaCampo3(Boleto boleto) {
		String campo = boleto.getNossoNumero().substring(7) + boleto.getIOS()
				+ boleto.getCarteira();

		return boleto.getDigitoCampo(campo, 1);
	}

	String calculaCampo4(Boleto boleto) {
		String campo = getNumero() + String.valueOf(boleto.getMoeda())
				+ boleto.getFatorVencimento() + boleto.getValorTitulo() + "9"
				+ boleto.getCodCliente()
				+ String.valueOf(boleto.getNossoNumero()) + boleto.getIOS()
				+ boleto.getCarteira();

		return boleto.getDigitoCodigoBarras(campo);
	}

	String calculaCampo5(Boleto boleto) {
		String campo = boleto.getFatorVencimento() + boleto.getValorTitulo();
		return campo;
	}

}
