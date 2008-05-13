package br.com.caelum.stella.boleto;

/**
 * Implementa um emissor padrão
 * 
 * @author caue
 *
 */
public class EmissorPadrao implements Emissor {
	private String agencia;
	private String dvAgencia;
	private String contaCorrente;
	private String carteira;
	private String numConvenio;
	private String nossoNumero;
	private String cedente;
	private String dvContaCorrete;
	
	private EmissorPadrao() {
	}
	
	/**
	 * Cria um novo emissor
	 * 
	 * @return
	 */
	public static EmissorPadrao newEmissor() {
		return new EmissorPadrao();
	}
	
	public String getAgencia() {
		return this.agencia;
	}
	
	/**
	 * Associa uma agencia, SEM o dígito verificador, ao emissor
	 * 
	 * @param agencia
	 * @return
	 */
	public EmissorPadrao comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}
	
	public String getContaCorrente() {
		return this.contaCorrente;
	}
	
	/**
	 * Associa uma conta corrente, SEM o dígito verificador, ao emissor
	 * 
	 * @param contaCorrente
	 * @return
	 */
	public EmissorPadrao comContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}
	
	public String getCarteira() {
		return this.carteira;
	}
	
	/**
	 * Associa uma carteira ao emissor
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 * @param carteira
	 * @return
	 */
	public EmissorPadrao comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}
	
	public String getNumConvenio() {
		return this.numConvenio;
	}
	
	/**
	 * Associa um número de convênio ao emissor
	 * Valor que identifica um emissor junto ao seu banco para associar seus boletos
	 * Valor informado pelo banco
	 * 
	 * @param numConvenio
	 * @return
	 */
	public EmissorPadrao comNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}
	
	public String getNossoNumero() {
		return this.nossoNumero;
	}
	
	/**
	 * Associa o nosso número ao emissor
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse valor serve
	 * para o cedente identificar quais boletos foram pagos ou não. Recomenda-se o uso de números
	 * sequenciais, na geração de diversos boletos, para facilitar a identificação dos boletos pagos
	 * 
	 * @param nossoNumero
	 * @return
	 */
	public EmissorPadrao comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}
	
	public String getCedente() {
		return this.cedente;
	}
	
	/**
	 * Associa um cedente (nome) ao emissor
	 * 
	 * @param cedente
	 * @return
	 */
	public EmissorPadrao comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	public String getDvContaCorrente() {
		return this.dvContaCorrete;
	}
	
	/**
	 * Associa um dígito verificador de conta corrente ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public EmissorPadrao comDvContaCorrete(String dv) {
		this.dvContaCorrete = dv;
		return this;
	}

	public String getDvAgencia() {
		return this.dvAgencia;
	}
	
	/**
	 * Associa um dígito verificador de agencia ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public EmissorPadrao comDvAgencia(String dv) {
		this.dvAgencia = dv;
		return this;
	}
	
	public String getContaCorrenteFormatado() {
		return String.format("%08d", Integer.parseInt(this.contaCorrente));
	}
}
