package br.com.caelum.stella.gateway.bb;

import br.com.caelum.stella.gateway.core.GatewaysConf;

public class BBDadosConfiguracao {

	private BBDadosFiliacao dadosFiliacao;
	private String urlInforma;
	private String urlRetorno;
	private String urlComponenteAutorizacao;
	private String urlSonda;

	public BBDadosConfiguracao(int idConv, Integer codigoConvenioCobranca,
			String urlInforma, String urlRetorno,
			String urlComponenteAutorizacao, String urlSonda) {
		super();
		this.dadosFiliacao = new BBDadosFiliacao(idConv, codigoConvenioCobranca);
		this.urlInforma = urlInforma;
		this.urlRetorno = urlRetorno;
		this.urlComponenteAutorizacao = urlComponenteAutorizacao;
		this.urlSonda = urlSonda;
	}

	public BBDadosConfiguracao() {
		GatewaysConf gatewaysConf = new GatewaysConf();
		this.dadosFiliacao = new BBDadosFiliacao(Integer.valueOf(gatewaysConf.getBBIdConv())
		,!"".equals(gatewaysConf.getBBCodigoConvenioDeCobranca())?Integer.valueOf(gatewaysConf.getBBCodigoConvenioDeCobranca()):null);
		this.urlInforma = gatewaysConf.getBBUrlInforma();
		this.urlRetorno = gatewaysConf.getBBUrlRetorno();
		this.urlComponenteAutorizacao = gatewaysConf.getBBUrlComponenteDeAutorizacao();
		this.urlSonda = gatewaysConf.getBBUrlSonda();
		// TODO Auto-generated constructor stub
	}

	public int getIdConv() {
		return dadosFiliacao.getIdConv();
	}

	public Integer getCodigoConvenioCobranca() {
		return dadosFiliacao.getCodigoConvenioCobranca();
	}

	public String getUrlInforma() {
		return urlInforma;
	}

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public String getUrlComponenteAutorizacao() {
		return urlComponenteAutorizacao;
	}

	public String getUrlSonda() {
		return urlSonda;
	}

}
