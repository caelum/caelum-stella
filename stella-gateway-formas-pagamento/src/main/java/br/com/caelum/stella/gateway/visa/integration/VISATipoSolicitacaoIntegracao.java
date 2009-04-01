package br.com.caelum.stella.gateway.visa.integration;

import br.com.caelum.stella.gateway.core.GatewaysConf;

/**
 * Classe responsáveis por indicar as urls de integração de cada componente do visa.
 * @author Alberto Pc
 *
 */
public enum VISATipoSolicitacaoIntegracao {

	CAPTURA(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub			
			return new GatewaysConf().getVISAUrlParaComponenteDeCaptura();
		}


		
		
		
	}
	,CANCELAMENTO(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getVISAUrlParaComponenteDeCancelamento();
		}
		
	}
	,CONSULTA(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getVISAUrlParaComponenteDeConsulta();
		}
		
	}
	,AUTORIZACAO(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getVISAUrlParaComponenteDeAutorizacao();
		}
		
	};	
	

	
	public abstract String getUrlComponente();		
		
}
