package br.com.caelum.stella.frete.enums;


public enum Servico{
	SEDEX("40010"), SEDEX_A_COBRAR("40045"),SEDEX_10("40215"),SEDEX_HOJE("40290"),PAC("41106"),SEDEX_12("40169");

	Servico(String codigo){
		this.codigo = codigo;
	}
	private String codigo;

	@Override
	public String toString(){
		return codigo;
	}

	public static Servico getServico(String codigo){
		for(Servico t : Servico.values()){
			if(t.toString().equalsIgnoreCase(codigo)){
				return t;
			}
		}
		return null;
	}
}
