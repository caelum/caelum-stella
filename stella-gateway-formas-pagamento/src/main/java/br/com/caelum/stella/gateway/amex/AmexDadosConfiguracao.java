package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.GatewaysConf;

/**
 * Classe para guardar os dados de configuração que são devolvidos entre
 * transações.
 * 
 * @author Alberto Souza
 * 
 */
public class AmexDadosConfiguracao {

	private String vpc_Version;
	private String vpc_Merchant;
	private String vpc_ReturnUrl;
	private String vpc_Command;
	private String vpc_AcessCode;	
	private String urlComponenteAutorizacao;

	public AmexDadosConfiguracao(String vpc_Version, String vpc_Merchant,
			String vpc_ReturnUrl, String vpc_Command, String vpc_AcessCode,String urlComponenteAutorizacao) {
		super();
		this.vpc_Version = vpc_Version;
		this.vpc_Merchant = vpc_Merchant;
		this.vpc_ReturnUrl = vpc_ReturnUrl;
		this.vpc_Command = vpc_Command;
		this.vpc_AcessCode = vpc_AcessCode;
		this.urlComponenteAutorizacao = urlComponenteAutorizacao;
	}

	/**
	 * inicia os atributos com os dados configurados no arquivo de configuracao.
	 */
	public AmexDadosConfiguracao() {
		GatewaysConf gatewaysConf = new GatewaysConf();
		this.vpc_Version = gatewaysConf.getAmexVpcVersion();
		this.vpc_AcessCode = gatewaysConf.getAmexVpcAccesCode();
		this.vpc_Merchant = gatewaysConf.getAmexMerchantId();
		this.vpc_ReturnUrl = gatewaysConf.getAmexVpcReturnUrl();
		this.vpc_Command = gatewaysConf.getAmexVpcCommand();
		this.urlComponenteAutorizacao = gatewaysConf.getAmexUrlComponenteDeAutorizacao();
		// TODO Auto-generated constructor stub
	}

	public String getVpc_Version() {
		return vpc_Version;
	}

	public String getVpc_Merchant() {
		return vpc_Merchant;
	}

	public String getVpc_ReturnUrl() {
		return vpc_ReturnUrl;
	}

	public String getVpc_Command() {
		return vpc_Command;
	}

	public String getVpc_AcessCode() {
		return vpc_AcessCode;
	}

	public String getUrlComponenteAutorizacao() {
		return urlComponenteAutorizacao;
	}
	
	

}
