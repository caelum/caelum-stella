package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por criar o objeto que deve ser utilizado para realizar 
 * as possiveis conferências das compras.
 * 
 * @author Alberto Pc
 * 
 */
public class VISASolicitacaoConferenciaViaHttp implements
		IntegrationHandler<VISADadosConferencia> {
	
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




	public VISADadosConferencia handle() {
		// TODO Auto-generated method stub
		return new VISADadosConferencia(tid,dadosConfiguracao.getNomeArquivoConfiguracao(),solicitacaoConferencia.getUrlComponente());
	}

}
