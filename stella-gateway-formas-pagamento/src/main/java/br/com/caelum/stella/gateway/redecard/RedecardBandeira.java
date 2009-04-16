package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum RedecardBandeira implements DefinedByCode{

	MASTERCARD("MASTERCARD"),DINERS("DINERS");
	
	private String codigo;

	private RedecardBandeira(String codigo) {
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
