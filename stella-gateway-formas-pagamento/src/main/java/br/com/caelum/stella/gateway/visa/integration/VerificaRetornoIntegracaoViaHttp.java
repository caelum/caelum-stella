package br.com.caelum.stella.gateway.visa.integration;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;
import br.com.caelum.stella.gateway.visa.ComponentReturnHandler;

/**
 * Classe que verifica os possiveis retornos das integrações.
 * @author Alberto Pc
 *
 */
public class VerificaRetornoIntegracaoViaHttp implements
		IntegrationHandler<IntegrationReturn> {

	private HttpServletRequest request;
	private HttpReturnBuilder httpRetornoBuilder;

	/**
	 * 
	 * @param request request que contem as informações
	 * @param httpRetornoBuilder builder especifico para a ocasião.
	 */
	public VerificaRetornoIntegracaoViaHttp(final HttpServletRequest request,
			final HttpReturnBuilder httpRetornoBuilder) {
		super();
		this.request = request;
		this.httpRetornoBuilder = httpRetornoBuilder;
	}
	
	/**
	 * @return RetornoIntegracao
	 * @throws ProblematicTransactionException caso a resposta não contenha código válido.
	 */
	public IntegrationReturn handle() {
		// TODO Auto-generated method stub
		IntegrationReturn retornoIntegracao = httpRetornoBuilder.buildRetorno(request);		
		return new ComponentReturnHandler(retornoIntegracao).check();
	}

}
