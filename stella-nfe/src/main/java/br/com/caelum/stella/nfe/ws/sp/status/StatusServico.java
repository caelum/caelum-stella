package br.com.caelum.stella.nfe.ws.sp.status;

import br.com.caelum.stella.nfe.xsd.status.TRetConsStatServ;

public class StatusServico {

	private final TRetConsStatServ response;
	
	private final String statusSucesso = "107"; 

	public StatusServico(TRetConsStatServ response) {
		this.response = response;
	}
	
	public boolean isAtivo(){
		return statusSucesso.equals(response.getCStat());
	}
	
	public TRetConsStatServ getResponse() {
		return response;
	}
	
	public Class<TRetConsStatServ> getResponseClass(){
		return TRetConsStatServ.class;
	}

}
