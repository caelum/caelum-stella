package br.com.caelum.stella.gateway.bb;

import java.math.BigDecimal;

public class BBFormularioInformaReturn {

	private final BBBasicDataReturn dadosRetornoPadrao;
	private final BigDecimal valor;	

	public BBFormularioInformaReturn(final BBBasicDataReturn dadosRetornoPadrao,
			final BigDecimal valor) {		
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.valor = valor;		
	}



	public int getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}



	public String getRefTran() {
		return dadosRetornoPadrao.getRefTran();
	}



	public BigDecimal getValor() {
		return valor;
	}


	
}
