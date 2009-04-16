package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.DefinedByCode;

/**
 * Especifica a forma como vai ser o parcelamento
 * @author Alberto Pc
 *
 */
public enum RedecardTipoTransacao implements DefinedByCode{

	A_VISTA("04"),PARCELADO_JUROS_EMISSOR("06"),PARCELADO_JUROS_LOJISTA("08");
	
	private String codigo;

	private RedecardTipoTransacao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.codigo;
	}
	
	
}
