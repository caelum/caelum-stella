package br.com.caelum.stella.boleto;

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
	
	public static EmissorPadrao newEmissor() {
		return new EmissorPadrao();
	}
	
	public String getAgencia() {
		return this.agencia;
	}
	
	public EmissorPadrao comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}
	
	public String getContaCorrente() {
		return this.contaCorrente;
	}
	
	public EmissorPadrao comContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}
	
	public String getCarteira() {
		return this.carteira;
	}
	
	public EmissorPadrao comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}
	
	public String getNumConvenio() {
		return this.numConvenio;
	}
	
	public EmissorPadrao comNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}
	
	public String getNossoNumero() {
		return this.nossoNumero;
	}
	
	public EmissorPadrao comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}
	
	public String getCedente() {
		return this.cedente;
	}
	
	public EmissorPadrao comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	public String getDvContaCorrente() {
		return this.dvContaCorrete;
	}
	
	public EmissorPadrao comDvContaCorrete(String dv) {
		this.dvContaCorrete = dv;
		return this;
	}

	public String getDvAgencia() {
		return this.dvAgencia;
	}
	
	public EmissorPadrao comDvAgencia(String dv) {
		this.dvAgencia = dv;
		return this;
	}
	
	public String getContaCorrenteFormatado() {
		return String.format("%08d", Integer.parseInt(this.contaCorrente));
	}
}
