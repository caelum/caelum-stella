package br.com.caelum.stella.nfe;

public enum Estados {

	SP("35");
	
	private final String codigo;

	private Estados(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
