package br.com.caelum.stella.gateway.visa;


/**
 * Enum responsável por indicar as urls de integração de cada componente do visa.
 * @author Alberto Pc
 *
 */
public enum VISATipoSolicitacaoIntegracao {

	CAPTURA(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub			
			return new VISADadosConfiguracao().getUrlComponenteCaptura();
		}


		
		
		
	}
	,CANCELAMENTO(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new VISADadosConfiguracao().getUrlComponenteCancelamento();
		}
		
	}
	,CONSULTA(){

		@Override
		public String getUrlComponente() {
			// TODO Auto-generated method stub
			return new VISADadosConfiguracao().getUrlComponenteConsulta();
		}
		
	}
	,AUTORIZACAO(){

		@Override
		public String getUrlComponente() {
		
			// TODO Auto-generated method stub
			return new VISADadosConfiguracao().getUrlComponenteAutorizacao();
		}
		
	};	
			
	public abstract String getUrlComponente();		
		
}
