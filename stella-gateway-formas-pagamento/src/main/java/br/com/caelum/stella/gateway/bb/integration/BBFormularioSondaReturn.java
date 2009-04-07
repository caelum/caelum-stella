package br.com.caelum.stella.gateway.bb.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.gateway.bb.Situacao;
import br.com.caelum.stella.gateway.bb.TipoTransacao;

public class BBFormularioSondaReturn {

	private final BBBasicDataReturn dadosRetornoPadrao;	
	private final BigDecimal valor;	
	private final TipoTransacao tipoTransacao;
	private final Situacao situacao;
	private final Calendar dataPagamento;

	public BBFormularioSondaReturn(final BBBasicDataReturn dadosRetornoPadrao,
			final BigDecimal valor,
			final TipoTransacao tipoTransacao, final Situacao situacao,
			final Calendar dataPagamento) {
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

	public String getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

}
