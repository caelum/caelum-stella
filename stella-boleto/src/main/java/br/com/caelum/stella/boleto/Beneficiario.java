package br.com.caelum.stella.boleto;

import java.io.Serializable;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

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

	private String numeroConvenio; // BB...

	private Beneficiario() {
	}
	
	public String getAgenciaFormatada(){
		return leftPadWithZeros(agencia, 4);
	}

	public static Beneficiario novoBeneficiario() {
		return new Beneficiario();
	}

	public String getAgencia() {
		return agencia;
	}

	public Beneficiario comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public Beneficiario comDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
		return this;
	}

	public String getCodigoBeneficiario() {
		return codigoBeneficiario;
	}

	public Beneficiario comCodigoBeneficiario(String codigoBeneficiario) {
		this.codigoBeneficiario = codigoBeneficiario;
		return this;
	}

	public String getDigitoCodigoBeneficiario() {
		return digitoCodigoBeneficiario;
	}

	public Beneficiario comDigitoCodigoBeneficiario(String digitoCodigoBeneficiario) {
		this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
		return this;
	}

	public String getCarteira() {
		return carteira;
	}

	public Beneficiario comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public Beneficiario comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public Beneficiario comDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
		return this;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public Beneficiario comNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
		return this;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Beneficiario comEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	public Beneficiario comNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
		return this;
	}

	public String getDocumento() {
		return documento;
	}

	public Beneficiario comDocumento(String documento) {
		this.documento = documento;
		return this;
	}

}
