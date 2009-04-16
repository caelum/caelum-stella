package br.com.caelum.stella.gateway.bb;

import java.math.BigDecimal;
import java.util.Calendar;

public class BBFormularioSondaReturn {

	private BBBasicDataReturn dadosRetornoPadrao;
	private BigDecimal valor;
	private BBTipoTransacao tipoTransacao;
	private BBSituacao situacao;
	private Calendar dataPagamento;

	public BBFormularioSondaReturn(BBBasicDataReturn dadosRetornoPadrao,
			BigDecimal valor, BBTipoTransacao tipoTransacao,
			BBSituacao situacao, Calendar dataPagamento) {
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao;
		this.situacao = situacao;
		this.dataPagamento = dataPagamento;

	}

	public String getRefTran() {
		return dadosRetornoPadrao.getRefTran();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}

	public BBTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public BBSituacao getSituacao() {
		return situacao;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

}
