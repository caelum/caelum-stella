package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum AmexTipoTransacao implements DefinedByCode {

	A_VISTA(""),PARCELADO_JUROS_LOJISTA("PlanN"), PARCELADO_JUROS_EMISSOR("PlanAmex");

	private String codigo;

	private AmexTipoTransacao(String codigo) {
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
