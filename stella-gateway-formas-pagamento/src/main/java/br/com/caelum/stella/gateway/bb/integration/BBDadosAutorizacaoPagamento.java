package br.com.caelum.stella.gateway.bb.integration;

import br.com.caelum.stella.gateway.bb.Checkout;
import br.com.caelum.stella.gateway.bb.TipoTransacao;
import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.CalendarFormatter;


public class BBDadosAutorizacaoPagamento {

	private Checkout checkout;
	private String idConv;
	private String refTran;
	private String urlRetorno;
	private String urlInforma;
	
	public BBDadosAutorizacaoPagamento(Checkout checkout, String idConv,
			String refTran, String urlRetorno, String urlInforma) {
		super();
		this.checkout = checkout;
		this.idConv = idConv;
		this.refTran = refTran;
		this.urlRetorno = urlRetorno;
		this.urlInforma = urlInforma;
	}

	public String getIdConv() {
		return idConv;
	}

	public String getRefTran() {
		return refTran;
	}

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public String getUrlInforma() {
		return urlInforma;
	}

	public String getCep() {
		return checkout.getCep();
	}

	public String getCidade() {
		return checkout.getCidade();
	}

	public String getDataVencimentoFormatada() {
		return CalendarFormatter.calendarToString(checkout.getDataVencimento(),"%1$td%1$tm%1$tY");
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

	public TipoTransacao getTipoTransacao() {
		return checkout.getTipoTransacao();
	}

	/**
	 * 
	 * @return
	 */
	public String getValorFormatado() {
		return BigDecimalFormatter.bigDecimalToStringInCents(checkout.getValor());
	}
	
	
}
