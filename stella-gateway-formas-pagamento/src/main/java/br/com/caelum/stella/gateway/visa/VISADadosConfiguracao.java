package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.GatewaysConf;

public class VISADadosConfiguracao {

	private String urlComponenteAutorizacao;
	private String urlComponenteCaptura;
	private String urlComponenteCancelamento;
	private String urlComponenteConsulta;
	private long numeroFiliacao;
	private String nomeArquivoConfiguracao;

	public VISADadosConfiguracao(String urlComponenteAutorizacao,
			String urlComponenteCaptura, String urlComponenteCancelamento,
			String urlComponenteConsulta, long numeroFiliacao,
			String nomeArquivoConfiguracao) {
		super();
		this.urlComponenteAutorizacao = urlComponenteAutorizacao;
		this.urlComponenteCaptura = urlComponenteCaptura;
		this.urlComponenteCancelamento = urlComponenteCancelamento;
		this.urlComponenteConsulta = urlComponenteConsulta;
		this.numeroFiliacao = numeroFiliacao;
		this.nomeArquivoConfiguracao = nomeArquivoConfiguracao;
	}

	public VISADadosConfiguracao() {		
		GatewaysConf gatewaysConf = new GatewaysConf();
		this.urlComponenteAutorizacao = gatewaysConf.getVISAUrlParaComponenteDeAutorizacao();
		this.urlComponenteCancelamento = gatewaysConf.getVISAUrlParaComponenteDeCancelamento();
		this.urlComponenteCaptura = gatewaysConf.getVISAUrlParaComponenteDeCaptura();
		this.urlComponenteConsulta = gatewaysConf.getVISAUrlParaComponenteDeConsulta();
		this.numeroFiliacao = Long.valueOf(gatewaysConf.getVISANumeroDeFiliacao());
		this.nomeArquivoConfiguracao = gatewaysConf.getVISANomeDoArquivoDeConfiguracao();
		// TODO Auto-generated constructor stub
	}

	public String getUrlComponenteAutorizacao() {
		return urlComponenteAutorizacao;
	}

	public String getUrlComponenteCaptura() {
		return urlComponenteCaptura;
	}

	public String getUrlComponenteCancelamento() {
		return urlComponenteCancelamento;
	}

	public String getUrlComponenteConsulta() {
		return urlComponenteConsulta;
	}

	public long getNumeroFiliacao() {
		return numeroFiliacao;
	}

	public String getNomeArquivoConfiguracao() {
		return nomeArquivoConfiguracao;
	}

	
}
