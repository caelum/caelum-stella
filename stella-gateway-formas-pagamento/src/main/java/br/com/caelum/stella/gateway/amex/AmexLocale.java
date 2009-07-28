package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum AmexLocale implements DefinedByCode {

	EN("en"),PT_BR("pt_BR");

	private String codigo;

	private AmexLocale(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo;
	}

}
