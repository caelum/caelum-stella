package br.com.caelum.stella.gateway.amex;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * @author Alberto Souza
 *
 */
public class AmexAutorizacaoReturn {

	private AmexDadosConfiguracao amexDadosConfiguracao;
	private AmexCheckout checkout;
	private String vpc_Message;
	private String vpc_TxnResponseCode;
	private String vpc_AcqResponseCode;
	private BigInteger vpc_TransactionNo;
	private Integer vpc_BatchNo;
	private String vpc_ReceiptNo;
	private String vpc_AuthorizeId;
	private String vpc_SecureHash;

	public AmexAutorizacaoReturn(AmexDadosConfiguracao amexDadosConfiguracao,
			AmexCheckout checkout, String vpc_Message,
			String vpc_TxnResponseCode, String vpc_AcqResponseCode,
			BigInteger vpc_TransactionNo, Integer vpc_BatchNo,
			String vpc_ReceiptNo, String vpc_AuthorizeId, String vpc_SecureHash) {
		super();
		this.amexDadosConfiguracao = amexDadosConfiguracao;
		this.checkout = checkout;
		this.vpc_Message = vpc_Message;
		this.vpc_TxnResponseCode = vpc_TxnResponseCode;
		this.vpc_AcqResponseCode = vpc_AcqResponseCode;
		this.vpc_TransactionNo = vpc_TransactionNo;
		this.vpc_BatchNo = vpc_BatchNo;
		this.vpc_ReceiptNo = vpc_ReceiptNo;
		this.vpc_AuthorizeId = vpc_AuthorizeId;
		this.vpc_SecureHash = vpc_SecureHash;
	}

	public String getVpc_Message() {
		return vpc_Message;
	}

	public String getVpc_TxnResponseCode() {
		return vpc_TxnResponseCode;
	}

	public String getVpc_AcqResponseCode() {
		return vpc_AcqResponseCode;
	}

	public BigInteger getVpc_TransactionNo() {
		return vpc_TransactionNo;
	}

	public Integer getVpc_BatchNo() {
		return vpc_BatchNo;
	}

	public String getVpc_ReceiptNo() {
		return vpc_ReceiptNo;
	}

	public String getVpc_AuthorizeId() {
		return vpc_AuthorizeId;
	}

	public String getVpc_SecureHash() {
		return vpc_SecureHash;
	}

	public String getVpc_Command() {
		return amexDadosConfiguracao.getVpc_Command();
	}

	public String getVpc_Merchant() {
		return amexDadosConfiguracao.getVpc_Merchant();
	}

	public BigDecimal getVpc_Amount() {
		return checkout.getVpc_Amount();
	}

	public String getVpc_MerchTxnRef() {
		return checkout.getVpc_MerchTxnRef();
	}

	public String getVpc_OrderInfo() {
		return checkout.getVpc_OrderInfo();
	}

	public AmexTipoCartao getVpc_Card() {
		return checkout.getFormaPagamento().getTipoCartao();
	}

}
