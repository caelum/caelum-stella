package br.com.caelum.stella.gateway.redecard;

public enum Bandeira {

	MASTERCARD("MASTERCARD"),DINERS("DINERS");
	
	private String codigo;

	private Bandeira(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	
}
