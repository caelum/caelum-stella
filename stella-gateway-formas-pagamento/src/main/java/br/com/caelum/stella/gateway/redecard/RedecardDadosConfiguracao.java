package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.GatewaysConf;

public class RedecardDadosConfiguracao {

	private String urlComponenteAutorizacao;
	private String urlRetornoTransacao;
	private String urlConfirmacaoTransacao;
	private RedecardDadosFiliacao dadosFiliacao;

	public RedecardDadosConfiguracao(String urlComponenteAutorizacao,
			int numeroFiliacaoFornecedor, Integer numeroFiliacaoDistribuidor,
			String urlRetornoTransacao, String urlConfirmacaoTransacao) {
		super();
		this.urlComponenteAutorizacao = urlComponenteAutorizacao;
		this.dadosFiliacao = new RedecardDadosFiliacao(
				numeroFiliacaoFornecedor, numeroFiliacaoDistribuidor);
		this.urlRetornoTransacao = urlRetornoTransacao;
		this.urlConfirmacaoTransacao = urlConfirmacaoTransacao;
	}

	public RedecardDadosConfiguracao() {
		super();
		GatewaysConf gatewaysConf = new GatewaysConf();
		this.urlComponenteAutorizacao = gatewaysConf
				.getRedeCardUrlConfirmacaoTransacao();
		this.dadosFiliacao = new RedecardDadosFiliacao(Integer
				.valueOf(gatewaysConf.getRedeCardNumeroDeFiliacao()), !""
				.equals(gatewaysConf
						.getRedeCardNumeroDeFiliacaoDoDistribuidor()) ? Integer
				.valueOf(gatewaysConf
						.getRedeCardNumeroDeFiliacaoDoDistribuidor()) : null);

		this.urlRetornoTransacao = gatewaysConf
				.getRedeCardUrlRetornoTransacao();
		this.urlConfirmacaoTransacao = gatewaysConf
				.getRedeCardUrlConfirmacaoTransacao();
		// TODO Auto-generated constructor stub
	}

	public String getUrlComponenteAutorizacao() {
		return urlComponenteAutorizacao;
	}

	public int getNumeroFiliacaoFornecedor() {
		return dadosFiliacao.getFiliacao();
	}

	public Integer getNumeroFiliacaoDistribuidor() {
		return dadosFiliacao.getFiliacaoDistribuidor();
	}

	public String getUrlRetornoTransacao() {
		return urlRetornoTransacao;
	}

	public String getUrlConfirmacaoTransacao() {
		return urlConfirmacaoTransacao;
	}

}
