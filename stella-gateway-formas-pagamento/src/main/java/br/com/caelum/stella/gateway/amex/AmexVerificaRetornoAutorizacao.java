package br.com.caelum.stella.gateway.amex;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

/**
 * Verifica o retorno da transação realizada através da interface do Amex
 * 
 * @author Alberto Pc
 * 
 */
public class AmexVerificaRetornoAutorizacao implements
		IntegrationHandler<AmexAutorizacaoReturn> {

	private HttpServletRequest request;

	public AmexVerificaRetornoAutorizacao(HttpServletRequest request) {
		this.request = request;
	}

	public AmexAutorizacaoReturn handle() {
		// TODO Auto-generated method stub
		String codigoRetorno = request.getParameter("vpc_TxnResponseCode");
		String mensagemRetorno = request.getParameter("vpc_Message");
		String secureHash = request.getParameter("vpc_SecureHash");
		AmexDadosConfiguracao amexDadosConfiguracao = new AmexDadosConfiguracao(
				null, request.getParameter("vpc_Merchant"), null, request
						.getParameter("vpc_Command"), null,null);
		AmexCheckout checkout = new AmexCheckout(request
				.getParameter("vpc_MerchTxnRef"), request
				.getParameter("vpc_OrderInfo"), new BigDecimalFormatter()
				.stringInCentsToBigDecimal(request.getParameter("vpc_Amount")),
				null, new AmexFormaPagamento(new EnumComCodigoFinder()
						.descobreAEnumPeloCodigo(AmexTipoCartao.class, request
								.getParameter("vpc_Card"))));
		if (!"0".equals(codigoRetorno)) {
			throw new ProblematicTransactionException(mensagemRetorno,
					new AmexAutorizacaoReturn(amexDadosConfiguracao, checkout,
							mensagemRetorno, codigoRetorno, null, null, null,
							null, null, secureHash));
		}
		return new AmexAutorizacaoReturn(amexDadosConfiguracao, checkout,
				mensagemRetorno, codigoRetorno, request
						.getParameter("vpc_AcqResponseCode"), new BigInteger(
						request.getParameter("vpc_TransactionNo")), Integer
						.valueOf(request.getParameter("vpc_BatchNo")), request
						.getParameter("vpc_ReceiptNo"), request
						.getParameter("vpc_AuthorizeId"),"00");
	}

}
