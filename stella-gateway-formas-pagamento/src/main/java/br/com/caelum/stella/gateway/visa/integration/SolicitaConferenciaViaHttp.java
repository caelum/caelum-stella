package br.com.caelum.stella.gateway.visa.integration;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por fazer as integrações que visam conferir o status da autorização de pagamento
 * @author Alberto Pc
 *
 */
public class SolicitaConferenciaViaHttp implements IntegrationHandler<String> {
		
	private final GatewaysConf gatewaysConf = new GatewaysConf();
	private String tid;
	private TipoSolicitacaoIntegracao solicitacaoConferencia;
	

	public SolicitaConferenciaViaHttp(final String tid,final TipoSolicitacaoIntegracao solicitacaoConferencia) {
		this.tid = tid;
		this.solicitacaoConferencia = solicitacaoConferencia;
	}



	public String handle() {
		// TODO Auto-generated method stub	
		PostMethod post = new PostMethod(solicitacaoConferencia.getUrlComponente());
		post.addParameter("tid",tid);
		post.addParameter("merchid",gatewaysConf.getNomeDoArquivoDeConfiguracaoDoVisa());
		return new HttpIntegrationRequester(post).makeRequest();
	}

}
