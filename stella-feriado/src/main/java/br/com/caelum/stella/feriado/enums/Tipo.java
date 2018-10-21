package br.com.caelum.stella.feriado.enums;


public enum Tipo {
	NACIONAL("Nacional"),MUNICIPAL("Municipal"),ESTADUAL("Estadual");

	Tipo(String tipo){
		this.tipo= tipo;
	}
	private String tipo;

	@Override
	public String toString(){
		return tipo;
	}

	public static Tipo getTipo(String tipo){
		for(Tipo t : Tipo.values()){
			if(t.toString().equalsIgnoreCase(tipo)){
				return t;
			}
		}
		return null;
	}
}