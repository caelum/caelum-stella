package br.com.caelum.stella.gateway.visa;

import java.util.Calendar;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por solicitar uma autorização de pagamento.
 * 
 * @author Alberto Pc
 * 
 */
public class VISASolicitacaoAutorizacaoPagamentoViaHttp implements
		IntegrationHandler<String> {

	private VISACheckout checkout;
	private VISADadosConfiguracao dadosConfiguracao;

	public VISASolicitacaoAutorizacaoPagamentoViaHttp(VISACheckout checkout) {
		this(checkout,new VISADadosConfiguracao());		
	}
	
	

	public VISASolicitacaoAutorizacaoPagamentoViaHttp(VISACheckout checkout,
			VISADadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
	}



	public String handle() {
		// TODO Auto-generated method stub
		PostMethod post = new PostMethod(dadosConfiguracao.getUrlComponenteAutorizacao());
		post.addParameter("tid", checkout.getTid(Calendar.getInstance(),
				dadosConfiguracao.getNumeroFiliacao()));
		post.addParameter("merchid",dadosConfiguracao.getNomeArquivoConfiguracao());
		post.addParameter("orderid", checkout.getOrderId());
		post.addParameter("order", checkout.getOrder());
		post.addParameter("free", checkout.getFree());
		post.addParameter("ccn", String.valueOf(checkout.getCartao().getCcn()));
		post.addParameter("exp", checkout.getCartao().getExpFormatado());
		post.addParameter("cvv2", String.valueOf(checkout.getCartao().getCvv2()));
		post.addParameter("price", checkout.getValorFormatado());
		return new HttpIntegrationRequester(post).makeRequest();
	}

}
