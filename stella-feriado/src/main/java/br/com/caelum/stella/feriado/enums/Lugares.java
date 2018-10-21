package br.com.caelum.stella.feriado.enums;

public enum Lugares {

	RJ("RJ"),SP("SP"),Brasil("Nacional");

	private String sigla;

	Lugares(String sigla){
		this.sigla=sigla;
	}

	@Override
	public String toString(){
		return sigla;
	}

	public static Lugares getTipo(String sigla){
		for(Lugares e : Lugares.values()){
			if(e.toString().equalsIgnoreCase(sigla)){
				return e;
			}
		}
		return null;
	}
}