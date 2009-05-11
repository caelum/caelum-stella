package br.com.caelum.stella.gateway.amex;

import java.math.BigDecimal;

/**
 * Representa o checkout para o Amex.
 * 
 * @author Alberto Souza
 * 
 */
public class AmexCheckout {

	private String vpc_MerchTxnRef;
	private String vpc_OrderInfo;
	private BigDecimal vpc_Amount;
	private AmexLocale vpc_Locale;
	private AmexFormaPagamento formaPagamento;

	public AmexCheckout(String vpc_MerchTxnRef, String vpc_OrderInfo,
			BigDecimal vpc_Amount, AmexLocale vpc_Locale,
			AmexFormaPagamento formaPagamento) {
		super();
		this.vpc_MerchTxnRef = vpc_MerchTxnRef;
		this.vpc_OrderInfo = vpc_OrderInfo;
		this.vpc_Amount = vpc_Amount;
		this.vpc_Locale = vpc_Locale;
		this.formaPagamento = formaPagamento;
	}

	public String getVpc_MerchTxnRef() {
		return vpc_MerchTxnRef;
	}

	public String getVpc_OrderInfo() {
		return vpc_OrderInfo;
	}

	public BigDecimal getVpc_Amount() {
		return vpc_Amount;
	}

	public AmexLocale getVpc_Locale() {
		return vpc_Locale;
	}

	public AmexFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

}
