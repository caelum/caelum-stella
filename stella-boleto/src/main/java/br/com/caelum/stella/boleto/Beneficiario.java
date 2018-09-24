package br.com.caelum.stella.boleto;

import java.io.Serializable;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * Beneficiário é a empresa/pessoa que emite o boleto.
 */
public class Beneficiario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String agencia;
	private String digitoAgencia;

	private String codigoBeneficiario;
	private String digitoCodigoBeneficiario;

	private String carteira;
	private String nossoNumero;
	private String digitoNossoNumero;
	
	private String nomeBeneficiario;
	private String documento;
	private Endereco endereco = Endereco.novoEndereco();

	private String numeroConvenio; //Exigência do BB: número do convênio
	private Modalidade modalidade = Modalidade.COM_REGISTRO; //C ou S Registro

	private Beneficiario() {
	}
	
	/**
	 * @return agencia formatada com 4 digitos
	 * Para o valor de agencia 123 retorna a String 0123
	 */	
	public String getAgenciaFormatada(){
		return leftPadWithZeros(agencia, 4);
	}

	/**
	 * @return um novo Beneficiario
	 */
	public static Beneficiario novoBeneficiario() {
		return new Beneficiario();
	}

	/**
	 * @return número da agência sem o digito
	 */	
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia, que deverá ser informada
	 * <strong>sem</strong> o digito verificador
	 * 
	 * @return este beneficiario
	 */	
	public Beneficiario comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	/**
	 * @return digito verificador (DV) da agencia
	 */	
	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	/**
	 * @param digito - verificador (DV) da agencia
	 * @return este beneficiario
	 */	
	public Beneficiario comDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
		return this;
	}

	/**
	 * @return código fornecido pela agência do beneficiário.
	 */	
	public String getCodigoBeneficiario() {
		return codigoBeneficiario;
	}

	/**
	 * @param código fornecido pela agência do beneficiário.
	 * @return este beneficiario
	 */	
	public Beneficiario comCodigoBeneficiario(String codigoBeneficiario) {
		this.codigoBeneficiario = codigoBeneficiario;
		return this;
	}

	/**
	 * @return digito - verificador (DV) do código do beneficiário
	 * @return este beneficiario
	 */	
	public String getDigitoCodigoBeneficiario() {
		return digitoCodigoBeneficiario;
	}

	/**
	 * @param digito - verificador (DV) do código do beneficiário
	 * @return este beneficiario
	 */	
	public Beneficiario comDigitoCodigoBeneficiario(String digitoCodigoBeneficiario) {
		this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
		return this;
	}

	/**
	 * @return carteira <br> Valor informado pelo 
	 * banco para identificação do tipo de boleto
	 */	
	public String getCarteira() {
		return carteira;
	}

	/**
	 * @param carteira <br> Valor informado pelo 
	 * banco para identificação do tipo de boleto
	 * @return este beneficiario
	 */	
	public Beneficiario comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}

	/**
	 * @return nossoNumero <br> Valor que o beneficiário escolhe 
	 * para manter controle sobre seus boletos. 
	 */	
	public String getNossoNumero() {
		return nossoNumero;
	}

	/**
	 * @param nossoNumero <br> Valor que o beneficiário escolhe 
	 * para manter controle sobre seus boletos. Esse valor serve 
	 * para o beneficiário identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de 
	 * diversos boletos, para facilitar a identificação dos pagos
	 * @return este beneficiario
	 */	
	public Beneficiario comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	/**
	 * @return digito verificador do nosso número.
	 */
	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	/**
	 * @param digitoNossoNumero, que será associado ao beneficiário
	 * @return este beneficiario
	 */	
	public Beneficiario comDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
		return this;
	}

	/**
	 * @return nome do beneficiário.
	 */
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	/**
	 * @param nome do beneficiário. Por exemplo: razão social ou nome 
	 * fantasia do Beneficiário.
	 * @return esse beneficiario
	 */	
	public Beneficiario comNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
		return this;
	}

	/**
	 * @return o endereço do beneficiário
	 */	
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco, que será associado ao beneficiário
	 * @return este beneficiario
	 */	
	public Beneficiario comEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

	/**
	 * @return número do convênio <br> Valor que identifica 
	 * um beneficiário junto ao seu banco para associar seus boletos
	 */	
	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	/**
	 * @param numeroConvenio <br> Valor que identifica um 
	 * beneficiário junto ao seu banco para associar seus boletos
	 * @return este beneficiario
	 */	
	public Beneficiario comNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
		return this;
	}

	/**
	 * @return CPF ou CNPJ do beneficiário
	 */	
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento <br> CPF ou CNPJ do beneficiário
	 * @return este beneficiario
	 */	
	public Beneficiario comDocumento(String documento) {
		this.documento = documento;
		return this;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}

	public Beneficiario comModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
		return this;
	}

}
