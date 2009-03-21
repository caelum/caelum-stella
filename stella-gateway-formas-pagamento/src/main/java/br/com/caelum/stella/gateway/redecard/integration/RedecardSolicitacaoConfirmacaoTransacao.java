package br.com.caelum.stella.gateway.redecard.integration;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.redecard.Checkout;

public class RedecardSolicitacaoConfirmacaoTransacao implements
		IntegrationHandler<RedecardConfirmacaoTransacaoReturn> {

	private static final String CODIGO_CONFIRMACAO_TRANSACAO = "203";
	private final GatewaysConf gatewaysConf = new GatewaysConf();
	private final RedecardAutorizacaoReturn autorizacaoReturn;
	private final Checkout checkout;

	public RedecardSolicitacaoConfirmacaoTransacao(
			RedecardAutorizacaoReturn autorizacaoReturn, Checkout checkout) {
		super();
		this.autorizacaoReturn = autorizacaoReturn;
		this.checkout = checkout;
		// talvez verificar o estado do checkout aqui...
	}

	public RedecardConfirmacaoTransacaoReturn handle() {
		// TODO Auto-generated method stub
		GetMethod getMethod = new GetMethod(gatewaysConf
				.getUrlConfirmacaoTransacaoRedecard());
		getMethod
				.setQueryString(new NameValuePair[] {
						new NameValuePair("DATA", autorizacaoReturn
								.getDataFormatada()),
						new NameValuePair("TRANSACAO",
								CODIGO_CONFIRMACAO_TRANSACAO),
						new NameValuePair("TRANSORIG", checkout
								.getParcelamento().getTipoTransacao()
								.getCodigo()),
						new NameValuePair("PARCELAS", checkout
								.getParcelamento()
								.getNumeroDeParcelasComNoMinimoDoisDigitos()),
						new NameValuePair("FILIACAO", gatewaysConf
								.getNumeroDeFiliacaoDaRedecard()),
						new NameValuePair("DISTRIBUIDOR", gatewaysConf
								.getNumeroDeFiliacaoDoDistribuidorDaRedecard()),
						new NameValuePair("TOTAL", checkout
								.getTotalComDuasCasasDecimais().toString()),
						new NameValuePair("NUMPEDIDO", checkout
								.getNumeroDoPedido()),
						new NameValuePair("NUMAUTOR", autorizacaoReturn
								.getNumAutor()),
						new NameValuePair("NUMCV", autorizacaoReturn.getNumCV()),
						new NameValuePair("NUMSQN", autorizacaoReturn
								.getNumSQN()),});

		String retorno = new HttpIntegrationRequester(getMethod).makeRequest();
		return new RedecardVerificadorRetornoConfirmacaoTransacao(retorno).verificaRetorno();
	}

}
