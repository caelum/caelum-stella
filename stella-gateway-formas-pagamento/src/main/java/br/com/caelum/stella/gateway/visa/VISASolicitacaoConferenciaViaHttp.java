package br.com.caelum.stella.gateway.visa;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por fazer as integrações que visam conferir o status da
 * autorização de pagamento
 * 
 * @author Alberto Pc
 * 
 */
public class VISASolicitacaoConferenciaViaHttp implements
		IntegrationHandler<String> {
	
	private String tid;
	private VISATipoSolicitacaoIntegracao solicitacaoConferencia;
	private VISADadosConfiguracao dadosConfiguracao;

	public VISASolicitacaoConferenciaViaHttp(String tid,
			VISATipoSolicitacaoIntegracao solicitacaoConferencia) {
		this(tid,solicitacaoConferencia,new VISADadosConfiguracao());
	}
	
	
	

	public VISASolicitacaoConferenciaViaHttp(String tid,
			VISATipoSolicitacaoIntegracao solicitacaoConferencia,
			VISADadosConfiguracao dadosConfiguracao) {		
		this.tid = tid;
		this.solicitacaoConferencia = solicitacaoConferencia;
		this.dadosConfiguracao = dadosConfiguracao;
	}




	public String handle() {
		// TODO Auto-generated method stub
		PostMethod post = new PostMethod(solicitacaoConferencia
				.getUrlComponente());
		post.addParameter("tid", tid);
		post.addParameter("merchid", dadosConfiguracao.getNomeArquivoConfiguracao());
		return new HttpIntegrationRequester(post).makeRequest();
	}

}
