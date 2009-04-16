package br.com.caelum.stella.gateway.bb;


public class BBFormualrioRetornoReturn {

	private final  BBBasicDataReturn dadosRetornoPadrao;
	private final BBTipoTransacao tipoTransacao;
	
	public BBFormualrioRetornoReturn(final BBBasicDataReturn dadosRetornoPadrao,
			final BBTipoTransacao tipoPagamento) {
		super();
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.tipoTransacao = tipoPagamento;
	}



	public int getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}



	public String getRefTran() {
		return dadosRetornoPadrao.getRefTran();
	}



	public BBTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	
	
}
