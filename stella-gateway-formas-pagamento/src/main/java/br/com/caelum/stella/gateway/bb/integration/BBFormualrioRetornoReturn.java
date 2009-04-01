package br.com.caelum.stella.gateway.bb.integration;

import br.com.caelum.stella.gateway.bb.TipoTransacao;

public class BBFormualrioRetornoReturn {

	private final  BBBasicDataReturn dadosRetornoPadrao;
	private final TipoTransacao tipoTransacao;
	
	public BBFormualrioRetornoReturn(final BBBasicDataReturn dadosRetornoPadrao,
			final TipoTransacao tipoPagamento) {
		super();
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.tipoTransacao = tipoPagamento;
	}



	public String getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}



	public String getRefTran() {
		return dadosRetornoPadrao.getRefTran();
	}



	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	
	
}
