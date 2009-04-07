package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.DefinedByCode;

/**
 * Especifica a forma como vai ser o parcelamento
 * @author Alberto Pc
 *
 */
public enum TipoTransacao implements DefinedByCode{

	A_VISTA("04"),PARCELADO_EMISSOR("06"),PARCELADO_ESTABELECIMENTO("08");
	
	private String codigo;

	private TipoTransacao(String codigo) {
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
