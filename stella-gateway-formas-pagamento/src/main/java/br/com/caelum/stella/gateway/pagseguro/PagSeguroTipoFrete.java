package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum PagSeguroTipoFrete implements DefinedByCode{

	PAC("EN"),SEDEX("SD"),USUARIO_DECIDE(""),DEFINIDO_PELO_VENDEDOR("FR");
	
	private String codigo;
	
	private PagSeguroTipoFrete(String codigo){
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
