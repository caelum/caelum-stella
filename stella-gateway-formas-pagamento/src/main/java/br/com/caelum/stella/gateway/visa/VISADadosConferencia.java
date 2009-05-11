package br.com.caelum.stella.gateway.visa;

public class VISADadosConferencia {

	private String tid;
	private String merchid;
	private String urlConferencia;
	
	VISADadosConferencia(String tid, String merchid,
			String urlConferencia) {
		super();
		this.tid = tid;
		this.merchid = merchid;
		this.urlConferencia = urlConferencia;
	}

	public String getTid() {
		return tid;
	}

	public String getMerchid() {
		return merchid;
	}

	public String getUrlConferencia() {
		return urlConferencia;
	}
	
	
}
