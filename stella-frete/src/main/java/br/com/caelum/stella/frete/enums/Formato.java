package br.com.caelum.stella.frete.enums;

public enum Formato {

	
	CAIXA("1"), ROLO("2"),ENVELOPE("3");

	Formato(String codigo){
		this.codigo = codigo;
	}
	private String codigo;

	@Override
	public String toString(){
		return codigo;
	}

	public static Formato getFormato(String codigo){
		for(Formato t : Formato.values()){
			if(t.toString().equalsIgnoreCase(codigo)){
				return t;
			}
		}
		return null;
	}
}
