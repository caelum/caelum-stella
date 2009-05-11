package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum TipoAutenticacao implements DefinedByCode{

	AUTORIZADA("1"),NAO_AUTORIZADA("0");
	
	private String codigo;
	
	private TipoAutenticacao(String codigo){
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
