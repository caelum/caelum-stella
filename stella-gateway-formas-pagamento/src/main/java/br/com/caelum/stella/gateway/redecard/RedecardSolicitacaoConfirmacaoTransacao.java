package br.com.caelum.stella.gateway.redecard;

import java.math.BigDecimal;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class RedecardSolicitacaoConfirmacaoTransacao implements
		IntegrationHandler<RedecardConfirmacaoTransacaoReturn> {

	private static final String CODIGO_CONFIRMACAO_TRANSACAO = "203";	
	private RedecardAutorizacaoReturn autorizacaoReturn;
	private RedecardCheckout checkoutASerVerificado;
	private RedecardDadosConfiguracao dadosConfiguracao;

	public RedecardSolicitacaoConfirmacaoTransacao(
			RedecardAutorizacaoReturn autorizacaoReturn,
			RedecardFormaPagamento parcelamento, BigDecimal total,RedecardDadosConfiguracao dadosConfiguracao) {
		super();
		this.autorizacaoReturn = autorizacaoReturn;
		this.checkoutASerVerificado = new RedecardCheckout(total, parcelamento,
				null, null, null);
		this.dadosConfiguracao = dadosConfiguracao;
	}
	
	

	public RedecardSolicitacaoConfirmacaoTransacao(
			RedecardAutorizacaoReturn autorizacaoReturn,
			RedecardFormaPagamento parcelamento, BigDecimal total) {
		this(autorizacaoReturn,parcelamento,total,new RedecardDadosConfiguracao());
				
	}



	public RedecardConfirmacaoTransacaoReturn handle() {
		// TODO Auto-generated method stub
		GetMethod getMethod = new GetMethod(dadosConfiguracao.getUrlConfirmacaoTransacao());
		getMethod
				.setQueryString(new NameValuePair[] {
						new NameValuePair("DATA", autorizacaoReturn
								.getDataFormatada()),
						new NameValuePair("TRANSACAO",
								CODIGO_CONFIRMACAO_TRANSACAO),
						new NameValuePair("TRANSORIG", checkoutASerVerificado
								.getFormaPagamento().getTipoTransacao()
								.getCodigo()),
						new NameValuePair("PARCELAS", checkoutASerVerificado
								.getFormaPagamento()
								.getNumeroDeParcelasComNoMinimoDoisDigitos()),
						new NameValuePair("FILIACAO", String.valueOf(dadosConfiguracao.getNumeroFiliacaoFornecedor())),
						new NameValuePair("DISTRIBUIDOR",String.valueOf(dadosConfiguracao.getNumeroFiliacaoFornecedor())),
						new NameValuePair("TOTAL", checkoutASerVerificado
								.getTotalComDuasCasasDecimais().toString()),
						new NameValuePair("NUMPEDIDO", autorizacaoReturn
								.getNumPedido()),
						new NameValuePair("NUMAUTOR", autorizacaoReturn
								.getNumAutor()),
						new NameValuePair("NUMCV", autorizacaoReturn.getNumCV()),
						new NameValuePair("NUMSQN", autorizacaoReturn
								.getNumSQN()), });

		String retorno = new HttpIntegrationRequester(getMethod).makeRequest();
		return new RedecardVerificadorRetornoConfirmacaoTransacao(retorno)
				.verificaRetorno();
	}

}
