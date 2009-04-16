package br.com.caelum.stella.gateway.redecard;

public enum RedecardIdiomaOperacao {

	ESPANHOL("S"),INGLES("E");
	
	private String codigo;

	private RedecardIdiomaOperacao(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
