package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum PagSeguroMoeda implements DefinedByCode{

	BRASIL_REAL("BRL");
	
	private String codigo;
	
	private PagSeguroMoeda(String codigo){
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

