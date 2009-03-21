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
			return new GatewaysConf().getUrlParaComponenteDeCapturaDoVisa();
		}


		
		
		
	}
	,CANCELAMENTO(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getUrlParaComponenteDeCancelamentoDoVisa();
		}
		
	}
	,CONSULTA(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getUrlParaComponenteDeConsultaDoVisa();
		}
		
	}
	,AUTORIZACAO(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new GatewaysConf().getUrlParaComponenteDeAutorizacaoDoVisa();
		}
		
	};	
	

	
	public abstract String getUrlComponente();		
		
}
