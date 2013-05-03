package br.com.caelum.stella.boleto;

/**
 * Bean que representa os dados do emissor de um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * @author David Paniz
 * 
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
	private String codigoCliente;

	private Emissor() {
	}

	/**
	 * Cria novo emissor
	 * 
	 * @return
	 */
	public static Emissor novoEmissor() {
		return new Emissor();
	}

	/**
	 * Associa um endereço ao emissor
	 * 
	 * @param endereco
	 * @return este emissor
	 */
	public Emissor comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	/**
	 * Retorna o endereço do Emissor.
	 * 
	 * @return
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Devolve o número da agencia sem o digito
	 * 
	 */
	public int getAgencia() {
		return this.agencia;
	}

	/**
	 * Associa uma agencia, SEM o dígito verificador, ao emissor
	 * 
	 * @param agencia
	 */
	public Emissor comAgencia(int agencia) {
		this.agencia = agencia;
		return this;
	}

	/**
	 * Devolve o número da conta corrente sem o digito
	 * 
	 */
	public long getContaCorrente() {
		return this.contaCorrente;
	}

	/**
	 * Associa uma conta corrente, SEM o dígito verificador, ao emissor
	 * 
	 * @param contaCorrente
	 */
	public Emissor comContaCorrente(long contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	/**
	 * Devolve a carteira<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 */
	public int getCarteira() {
		return this.carteira;
	}

	/**
	 * Associa uma carteira ao emissor<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 * @param carteira
	 */
	public Emissor comCarteira(int carteira) {
		this.carteira = carteira;
		return this;
	}

	/**
	 * Devolve o número do convênio<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 */
	public long getNumeroConvenio() {
		return this.numeroConvenio;
	}

	/**
	 * Associa um número de convênio ao emissor<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 * @param numConvenio
	 */
	public Emissor comNumeroConvenio(long numConvenio) {
		this.numeroConvenio = numConvenio;
		return this;
	}

	/**
	 * Devolve o nosso número<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 */
	public long getNossoNumero() {
		return this.nossoNumero;
	}

	/**
	 * Associa o nosso número ao emissor<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 * @param nossoNumero
	 */
	public Emissor comNossoNumero(long nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	/**
	 * Devolve o cedente. (nome do emissor)
	 * 
	 */
	public String getCedente() {
		return this.cedente;
	}

	/**
	 * Associa um cedente (nome) ao emissor
	 * 
	 * @param cedente
	 */
	public Emissor comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	/**
	 * Devolve o digito verificador (DV) da conta corrente
	 * 
	 * @return
	 */
	public char getDigitoContaCorrente() {
		return this.digitoContaCorrente;
	}

	/**
	 * Associa um digito verificador (DV) da conta corrente ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor comDigitoContaCorrente(char dv) {
		this.digitoContaCorrente = dv;
		return this;
	}

	/**
	 * Devolve o digito verificador (DV) da agencia
	 * 
	 * @return
	 */
	public char getDigitoAgencia() {
		return this.digitoAgencia;
	}

	/**
	 * Associa um digito verificador (DV) da agencia ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor comDigitoAgencia(char dv) {
		this.digitoAgencia = dv;
		return this;
	}

	/**
	 * Devolve a agencia formatada (com 4 digitos)
	 * 
	 * @return
	 */
	public String getAgenciaFormatado() {
		String valor = String.valueOf(this.agencia);
		valor = String.format("%04d", Integer.parseInt(valor));
		return valor.substring(0, 4);
	}

	/**
	 * Devolve o código de operação do emissor.
	 * 
	 * @return
	 */
	public int getCodigoOperacao() {
		return this.codigoOperacao;
	}

	/**
	 * Associa um código de operação ao emissor.
	 * 
	 * @param codOperacao
	 * @return
	 */
	public Emissor comCodigoOperacao(int codOperacao) {
		this.codigoOperacao = codOperacao;
		return this;
	}

	/**
	 * Devolve o código fornecido pela agência do emissor.
	 * 
	 * @return
	 */
	public int getCodigoFornecidoPelaAgencia() {
		return this.codigoFornecidoPelaAgencia;
	}

	/**
	 * Associa um código fornecido pela agência ao emissor.
	 * 
	 * @param codFornecidoPelaAgencia
	 * @return
	 */
	public Emissor comCodigoFornecidoPelaAgencia(int codFornecidoPelaAgencia) {
		this.codigoFornecidoPelaAgencia = codFornecidoPelaAgencia;
		return this;
	}

	/**
	 * Associa o DV do nosso número ao emissor
	 * 
	 * @param dvNossoNumero
	 */
	public Emissor comDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
		return this;
	}

	/**
	 * Devolve o DV no nosso número associado ao emissor
	 * 
	 * @return
	 */
	public String getDigitoNossoNumero() {
		return this.digitoNossoNumero;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public Emissor comCodigoCliente(String codigoCliente) {
		String cod = String.format("%7s", codigoCliente);
		this.codigoCliente = cod.replaceAll(" ", "0");
		return this;
	}
}
