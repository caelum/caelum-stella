package br.com.caelum.stella.bean.validation;

@IE
public class ObjectWithIE {
	private String ie;
	private String estado;

	public ObjectWithIE(String ie, String estado) {
		super();
		this.ie = ie;
		this.estado = estado;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}