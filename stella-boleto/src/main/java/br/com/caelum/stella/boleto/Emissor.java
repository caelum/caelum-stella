package br.com.caelum.stella.boleto;

public interface Emissor {
	public String getAgencia();
	public String getContaCorrente();
	public String getDvContaCorrente();
	public String getCarteira();
	public String getNumConvenio();
	public String getNossoNumero();
	public String getCedente();
}
