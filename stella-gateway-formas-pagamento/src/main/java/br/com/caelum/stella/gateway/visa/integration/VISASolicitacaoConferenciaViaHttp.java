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
public class VISASolicitacaoConferenciaViaHttp implements IntegrationHandler<String> {
		
	private final GatewaysConf gatewaysConf = new GatewaysConf();
	private final String tid;
	private final VISATipoSolicitacaoIntegracao solicitacaoConferencia;
	

	public VISASolicitacaoConferenciaViaHttp(final String tid,final VISATipoSolicitacaoIntegracao solicitacaoConferencia) {
		this.tid = tid;
		this.solicitacaoConferencia = solicitacaoConferencia;
	}



	public String handle() {
		// TODO Auto-generated method stub	
		PostMethod post = new PostMethod(solicitacaoConferencia.getUrlComponente());
		post.addParameter("tid",tid);
		post.addParameter("merchid",gatewaysConf.getVISANomeDoArquivoDeConfiguracao());
		return new HttpIntegrationRequester(post).makeRequest();
	}

}
