package br.com.caelum.stella.boleto;

/**
 * Bean que representa os dados do emissor de um boleto 
 * bancario. É um bean genérico, ou seja, o uso dos campos 
 * varia de acordo com o banco pelo qual será gerado o boleto.
 * 
 * @author Paulo Silveira, Caue Guerra e David Paniz
 */
public class Emissor {
	
	private int agencia;
	private char digitoAgencia;
	private long contaCorrente;
	private int carteira;
	private long numeroConvenio;
	private long nossoNumero;
	private String cedente;
	private char digitoContaCorrente;
	private String digitoNossoNumero;
	private int codigoOperacao;
	private int codigoFornecidoPelaAgencia;
	private String endereco;

	private Emissor() {
	}

	/**
	 * @return um novo Emissor
	 */
	public static Emissor novoEmissor() {
		return new Emissor();
	}

	/**
	 * @param endereco, que será associado ao emissor
	 * @return este emissor
	 */
	public Emissor comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	/**
	 * @return o endereço do Emissor
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @return número da agencia sem o digito
	 */
	public int getAgencia() {
		return this.agencia;
	}

	/**
	 * @param agencia, que deverá ser informada
	 * <strong>sem</strong> o digito verificador
	 * 
	 * @return este emissor
	 */
	public Emissor comAgencia(int agencia) {
		this.agencia = agencia;
		return this;
	}

	/**
	 * @return número da conta corrente sem o digito
	 */
	public long getContaCorrente() {
		return this.contaCorrente;
	}

	/**
	 * @param contaCorrente, que deverá ser informada
	 * <strong>sem</strong> o digito verificador.
	 * 
	 * @return este emissor
	 */
	public Emissor comContaCorrente(long contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	/**
	 * @return carteira <br/> Valor informado pelo 
	 * banco para identificação do tipo de boleto
	 */
	public int getCarteira() {
		return this.carteira;
	}

	/**
	 * @param carteira <br/> Valor informado pelo 
	 * banco para identificação do tipo de boleto
	 * 
	 * @return este emissor
	 */
	public Emissor comCarteira(int carteira) {
		this.carteira = carteira;
		return this;
	}

	/**
	 * @return número do convênio <br/> Valor que identifica 
	 * um emissor junto ao seu banco para associar seus boletos
	 */
	public long getNumeroConvenio() {
		return this.numeroConvenio;
	}

	/**
	 * @param numConvenio <br/> Valor que identifica um 
	 * emissor junto ao seu banco para associar seus boletos
	 * 
	 * @return este emissor
	 */
	public Emissor comNumeroConvenio(long numConvenio) {
		this.numeroConvenio = numConvenio;
		return this;
	}

	/**
	 * @return nosso número <br/> Valor que o cedente escolhe 
	 * para manter controle sobre seus boletos. Esse valor serve 
	 * para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de 
	 * diversos boletos, para facilitar a identificação dos pagos
	 */
	public long getNossoNumero() {
		return this.nossoNumero;
	}

	/**
	 * @param nossoNumero <br/> Valor que o cedente escolhe 
	 * para manter controle sobre seus boletos. Esse valor serve 
	 * para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de 
	 * diversos boletos, para facilitar a identificação dos pagos
	 * 
	 * @return este emissor
	 */
	public Emissor comNossoNumero(long nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	/**
	 * @return cedente deste emissor (nome fornecido para boleto)
	 */
	public String getCedente() {
		return this.cedente;
	}

	/**
	 * @param cedente, que será associado a este emissor.
	 * @return este emissor
	 */
	public Emissor comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	/**
	 * @return digito verificador (DV) da conta corrente
	 */
	public char getDigitoContaCorrente() {
		return this.digitoContaCorrente;
	}

	/**
	 * @param digito - verificador (DV) da conta corrente
	 * @return este emissor
	 */
	public Emissor comDigitoContaCorrente(char digito) {
		this.digitoContaCorrente = digito;
		return this;
	}

	/**
	 * @return digito verificador (DV) da agencia
	 */
	public char getDigitoAgencia() {
		return this.digitoAgencia;
	}

	/**
	 * @param digito - verificador (DV) da agencia
	 * @return este emissor
	 */
	public Emissor comDigitoAgencia(char digito) {
		this.digitoAgencia = digito;
		return this;
	}

	/**
	 * @return agencia formatada com 4 digitos
	 * Para o valor de agencia 123 retorna a String 0123
	 */
	public String getAgenciaFormatado() {
		String valor = String.valueOf(this.agencia);
		valor = String.format("%04d", Integer.parseInt(valor));
		return valor.substring(0, 4);
	}

	/**
	 * @return código de operação do emissor
	 */
	public int getCodigoOperacao() {
		return this.codigoOperacao;
	}

	/**
	 * @param codigoOperacao, que será associado ao emissor
	 * @return este emissor
	 */
	public Emissor comCodigoOperacao(int codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
		return this;
	}

	/**
	 * @return código fornecido pela agência do emissor.
	 */
	public int getCodigoFornecidoPelaAgencia() {
		return this.codigoFornecidoPelaAgencia;
	}

	/**
	 * @param codigoFornecidoPelaAgencia, que será associado ao emissor
	 * @return este emissor
	 */
	public Emissor comCodigoFornecidoPelaAgencia(int codigoFornecidoPelaAgencia) {
		this.codigoFornecidoPelaAgencia = codigoFornecidoPelaAgencia;
		return this;
	}

	/**
	 * @param digitoNossoNumero, que será associado ao emissor
	 * @return este emissor
	 */
	public Emissor comDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
		return this;
	}

	/**
	 * @return digito verificador do nosso número associado ao emissor
	 */
	public String getDigitoNossoNumero() {
		return this.digitoNossoNumero;
	}
}
