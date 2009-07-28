package br.com.caelum.stella.gateway.visa;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

/**
 * Classe que verifica os possiveis retornos das integrações.
 * 
 * @author Alberto Pc
 * 
 */
public class VISAVerificacaoRetornoIntegracaoViaHttp implements
		IntegrationHandler<VISAIntegrationReturn> {

	private HttpServletRequest request;
	private VISAHttpReturnBuilder httpRetornoBuilder;

	/**
	 * 
	 * @param request
	 *            request que contem as informações
	 * @param httpRetornoBuilder
	 *            builder especifico para a ocasião.
	 */
	public VISAVerificacaoRetornoIntegracaoViaHttp(HttpServletRequest request,
			VISAHttpReturnBuilder httpRetornoBuilder) {
		super();
		this.request = request;
		this.httpRetornoBuilder = httpRetornoBuilder;
	}

	/**
	 * @return RetornoIntegracao
	 * @throws ProblematicTransactionException
	 *             caso a resposta não contenha código válido.
	 */
	public VISAIntegrationReturn handle() {
		// TODO Auto-generated method stub
		VISAIntegrationReturn retornoIntegracao = (VISAIntegrationReturn) httpRetornoBuilder
				.buildReturn(request);
		return new VISAComponentReturnHandler(retornoIntegracao).check();
	}

}
