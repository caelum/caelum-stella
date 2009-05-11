package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;

/**
 * 
 * @author Alberto Souza
 *
 */
public class AmexDadosAutorizacaoPagamento {

	private AmexCheckout checkout;
	private AmexDadosConfiguracao dadosConfiguracao;

	public AmexDadosAutorizacaoPagamento(AmexCheckout checkout,
			AmexDadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
	}

	public AmexFormaPagamento getFormaPagamento() {
		return checkout.getFormaPagamento();
	}

	public String getVpc_AmountFormatado() {
		return new BigDecimalFormatter().bigDecimalToStringInCents(checkout
				.getVpc_Amount());
	}

	public AmexLocale getVpc_Locale() {
		return checkout.getVpc_Locale();
	}

	public String getVpc_MerchTxnRef() {
		return checkout.getVpc_MerchTxnRef();
	}

	public String getVpc_OrderInfo() {
		return checkout.getVpc_OrderInfo();
	}

	public String getVpc_Merchant() {
		return dadosConfiguracao.getVpc_Merchant();
	}

	public String getVpc_ReturnUrl() {
		return dadosConfiguracao.getVpc_ReturnUrl();
	}

	public String getVpc_Version() {
		return dadosConfiguracao.getVpc_Version();
	}

	public String getVpc_Command() {
		return dadosConfiguracao.getVpc_Command();
	}

	public String getVpc_AcessCode() {
		return dadosConfiguracao.getVpc_AcessCode();
	}

	
}
