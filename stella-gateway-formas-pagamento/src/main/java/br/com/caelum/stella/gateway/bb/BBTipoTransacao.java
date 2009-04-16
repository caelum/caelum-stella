package br.com.caelum.stella.gateway.bb;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum BBTipoTransacao implements DefinedByCode{

	TODAS_MODALIDADES("0"), BLOQUETO_BANCARIO("2"), SEGUNDA_VIA_BLOQUETO_BANCARIO(
			"21"), DEBITO_EM_CONTA("3"), CREDIARIO_INTERNET("5");
	
	private String codigo;
	
	private BBTipoTransacao(String codigo){
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo;
	}
	
	
}


