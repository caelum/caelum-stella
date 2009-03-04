package br.com.caelum.stella.gateway.visa;

import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.FalhaIntegracaoException;
import br.com.caelum.stella.gateway.core.Integracao;

public class IntegracaoCheckoutViaPost implements Integracao<String> {

	private Checkout checkout;
	private final GatewaysConf gatewaysConf = new GatewaysConf();

	public IntegracaoCheckoutViaPost(Checkout checkout) {
		this.checkout = checkout;
	}

	public String integra() {
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();	
		PostMethod post = new PostMethod(gatewaysConf.getUrlParaComponenteDeAutorizacaoDoVisa());		
		post.addParameter("tid",checkout.getTid(Calendar.getInstance(),gatewaysConf.getNumeroDeAfiliacaoDoVisa()));
		post.addParameter("merchid",gatewaysConf.getNomeDoArquivoDeConfiguracaoDoVisa());
		post.addParameter("orderid",checkout.getOrderId());
		post.addParameter("order",checkout.getOrder());
		post.addParameter("free",checkout.getFree());
		post.addParameter("ccn",checkout.getCartao().getCcn());
		post.addParameter("exp",checkout.getCartao().getFormattedExp());
		post.addParameter("cvv2",checkout.getCartao().getCvv2());		
		post.addParameter("price",checkout.getFormattedPrice());
		try {
			int status = httpClient.executeMethod(post);			
			if(status==HttpStatus.SC_OK){
				//retornando a tela gerada pela url configurada no .ini
				return post.getResponseBodyAsString();
			}
			else{
				throw new FalhaIntegracaoException("O status de retorno da comunicação com a url configurada no .ini não foi o esperado(200). "+status);
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			throw new FalhaIntegracaoException("Problema para fazer a requisição para a url "+gatewaysConf.getUrlParaComponenteDeAutorizacaoDoVisa(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new FalhaIntegracaoException(e.getMessage(),e);
		}
	}

}
