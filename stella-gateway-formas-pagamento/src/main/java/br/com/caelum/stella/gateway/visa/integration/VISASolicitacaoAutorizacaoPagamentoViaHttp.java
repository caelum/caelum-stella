package br.com.caelum.stella.gateway.visa.integration;

import java.util.Calendar;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.visa.Checkout;

/**
 * Classe responsável por solicitar uma autorização de pagamento.
 * @author Alberto Pc
 *
 */
public class VISASolicitacaoAutorizacaoPagamentoViaHttp implements IntegrationHandler<String> {

	private final Checkout checkout;
	private final GatewaysConf gatewaysConf = new GatewaysConf();

	public VISASolicitacaoAutorizacaoPagamentoViaHttp(final Checkout checkout) {
		this.checkout = checkout;
	}

	public String handle() {
		// TODO Auto-generated method stub		
		PostMethod post = new PostMethod(gatewaysConf.getUrlParaComponenteDeAutorizacaoDoVisa());		
		post.addParameter("tid",checkout.getTid(Calendar.getInstance(),gatewaysConf.getNumeroDeFiliacaoDoVisa()));
		post.addParameter("merchid",gatewaysConf.getNomeDoArquivoDeConfiguracaoDoVisa());
		post.addParameter("orderid",checkout.getOrderId());
		post.addParameter("order",checkout.getOrder());
		post.addParameter("free",checkout.getFree());
		post.addParameter("ccn",checkout.getCartao().getCcn());
		post.addParameter("exp",checkout.getCartao().getFormattedExp());
		post.addParameter("cvv2",checkout.getCartao().getCvv2());		
		post.addParameter("price",checkout.getFormattedPrice());
		return new HttpIntegrationRequester(post).makeRequest();
	}

}
