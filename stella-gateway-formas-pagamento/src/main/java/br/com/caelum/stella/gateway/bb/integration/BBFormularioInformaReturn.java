package br.com.caelum.stella.gateway.bb.integration;

import java.math.BigDecimal;

public class BBFormularioInformaReturn {

	private final BBBasicDataReturn dadosRetornoPadrao;
	private final BigDecimal valor;
	private final String informacao;

	public BBFormularioInformaReturn(final BBBasicDataReturn dadosRetornoPadrao,
			final BigDecimal valor, final String informacao) {		
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.valor = valor;
		this.informacao = informacao;
	}

	public BBBasicDataReturn getDadosRetornoPadrao() {
		return dadosRetornoPadrao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getInformacao() {
		return informacao;
	}

	
}
