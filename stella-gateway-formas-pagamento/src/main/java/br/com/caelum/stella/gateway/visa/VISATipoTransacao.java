package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.DefinedByCode;

/**
 * 
 * @author Alberto
 *
 */
public enum VISATipoTransacao implements DefinedByCode{

	CREDITO_A_VISTA("1"),PARCELADO_JUROS_LOJISTA("2"),PARCELADO_JUROS_EMISSOR("3"),DEBITO("A");
	
	private String codigo;
	
	private VISATipoTransacao(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
