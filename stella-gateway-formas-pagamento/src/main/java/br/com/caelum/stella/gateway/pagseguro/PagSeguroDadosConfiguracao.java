package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.GatewaysConf;

public class PagSeguroDadosConfiguracao {

	private String urlComponenteAutorizacao;
	private String token;
	private String emailCobranca;
	private String urlVerificacaoToken;

	public PagSeguroDadosConfiguracao(String urlComponenteAutorizacao,
			String token, String emailCobranca,String urlVerificacaoToken) {
		super();
		this.urlComponenteAutorizacao = urlComponenteAutorizacao;
		this.token = token;
		this.emailCobranca = emailCobranca;
		this.urlVerificacaoToken = urlVerificacaoToken;
	}

	public PagSeguroDadosConfiguracao() {
		GatewaysConf gatewaysConf = new GatewaysConf();
		this.urlComponenteAutorizacao = gatewaysConf.getPagSeguroUrlComponenteDeAutorizacao();
		this.token = gatewaysConf.getPagSeguroToken();
		this.emailCobranca = gatewaysConf.getPagSeguroEmailCobranca();
		this.urlVerificacaoToken = gatewaysConf.getPagSeguroUrlVerificacaoToken();
		// TODO Auto-generated constructor stub
	}

	public String getUrlComponenteAutorizacao() {
		return urlComponenteAutorizacao;
	}

	public String getToken() {
		return token;
	}

	public String getEmailCobranca() {
		return emailCobranca;
	}

	public String getUrlVerificacaoToken() {
		return urlVerificacaoToken;
	}
	
	

}
