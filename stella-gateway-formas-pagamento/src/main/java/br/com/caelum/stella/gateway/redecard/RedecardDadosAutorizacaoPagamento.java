package br.com.caelum.stella.gateway.redecard;

import java.math.BigDecimal;


/**
 * Classe que contém todas as informações que são necessárias para serem passadas para o ambiente da redecard.
 * @author Alberto Pc
 *
 */
public class RedecardDadosAutorizacaoPagamento {

	private RedecardCheckout checkout;
	private RedecardDadosFiliacao dadosFiliacao;
	private String codVer;
	private String urlBack;
	private String urlCima;
	private String target;
	
	
	public RedecardDadosAutorizacaoPagamento(RedecardCheckout checkout,RedecardDadosFiliacao dadosFiliacao, String codVer, String urlBack,
			String urlCima, String target) {
		super();
		this.checkout = checkout;
		this.dadosFiliacao = dadosFiliacao;
		this.codVer = codVer;
		this.urlBack = urlBack;
		this.urlCima = urlCima;
		this.target = target;
	}


	public int getFiliacao() {
		return dadosFiliacao.getFiliacao();
	}


	public String getFiliacaoDistribuidor() {
		return dadosFiliacao.getFiliacaoDistribuidor()==null?"":dadosFiliacao.getFiliacaoDistribuidor().toString();
	}


	public String getCodVer() {
		return codVer;
	}


	public String getUrlBack() {
		return urlBack;
	}


	public String getUrlCima() {
		if(urlCima==null){
			urlCima = "";
		}
		return urlCima;
	}


	public String getTarget() {
		if(target==null){
			target = "";
		}
		return target;
	}


	public RedecardBandeira getBandeira() {
		return checkout.getBandeira();
	}


	public String getNumeroDoPedido() {
		return checkout.getNumeroDoPedido();
	}


	public RedecardFormaPagamento getFormaPagamento() {
		return checkout.getFormaPagamento();
	}


	public String getPax1() {
		return checkout.getPax1();
	}


	public BigDecimal getTotalComDuasCasasDecimais() {
		return checkout.getTotalComDuasCasasDecimais();
	}
	
	
	
	
	
	
	
}
