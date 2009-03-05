package br.com.caelum.stella.gateway.visa.integration;

import br.com.caelum.stella.gateway.core.GatewaysConf;


public enum TipoSolicitacaoIntegracao {

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
