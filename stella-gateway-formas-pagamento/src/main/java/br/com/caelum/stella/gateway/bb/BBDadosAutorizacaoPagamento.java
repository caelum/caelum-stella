package br.com.caelum.stella.gateway.bb;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.CalendarFormatter;


public class BBDadosAutorizacaoPagamento {

	private BBCheckout checkout;
	private BBBasicDataReturn dadosRetornoPadrao;
	private String urlRetornoFormatada;
	private String urlInformaFormatada;	
	
	public BBDadosAutorizacaoPagamento(BBCheckout checkout,BBBasicDataReturn dadosRetornoPadrao, String urlRetorno, String urlInforma) {
		super();
		this.checkout = checkout;
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.urlRetornoFormatada = urlRetorno;
		this.urlInformaFormatada = urlInforma;
	}

	public int getIdConv() {
		return dadosRetornoPadrao.getIdConv();
	}

	public String getRefTran() {
		return dadosRetornoPadrao.getRefTran();
	}
	
	

	public String getUrlRetornoFormatada() {
		return urlRetornoFormatada;
	}

	public String getUrlInformaFormatada() {
		return urlInformaFormatada;
	}

	public String getCep() {
		return checkout.getCep();
	}

	public String getCidade() {
		return checkout.getCidade();
	}

	public String getDataVencimentoFormatada() {
		return new CalendarFormatter().calendarToString(checkout.getDataVencimento(),"%1$td%1$tm%1$tY");
	}

	public String getEndereco() {
		return checkout.getEndereco();
	}

	public String getEstado() {
		return checkout.getEstado();
	}

	public String getMensagemLoja() {
		return checkout.getMensagemLoja();
	}

	public String getNome() {
		return checkout.getNome();
	}

	public BBTipoTransacao getTipoTransacao() {
		return checkout.getTipoTransacao();
	}

	/**
	 * 
	 * @return
	 */
	public String getValorFormatado() {
		return new BigDecimalFormatter().bigDecimalToStringInCents(checkout.getValor());
	}
	
	
}
