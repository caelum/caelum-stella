package br.com.caelum.stella.gateway.redecard.integration;

import java.math.BigDecimal;

import br.com.caelum.stella.gateway.redecard.Bandeira;
import br.com.caelum.stella.gateway.redecard.Checkout;
import br.com.caelum.stella.gateway.redecard.Parcelamento;

/**
 * Classe que contém todas as informações que são necessárias para serem passadas para o ambiente da redecard.
 * @author Alberto Pc
 *
 */
public class RedecardDadosAutorizacaoPagamento {

	private Checkout checkout;
	private String filiacao;
	private String filiacaoDistribuidor;
	private String codVer;
	private String urlBack;
	private String urlCima;
	private String target;
	
	
	public RedecardDadosAutorizacaoPagamento(Checkout checkout, String filiacao,
			String filiacaoDistribuidor, String codVer, String urlBack,
			String urlCima, String target) {
		super();
		this.checkout = checkout;
		this.filiacao = filiacao;
		this.filiacaoDistribuidor = filiacaoDistribuidor;
		this.codVer = codVer;
		this.urlBack = urlBack;
		this.urlCima = urlCima;
		this.target = target;
	}


	public String getFiliacao() {
		return filiacao;
	}


	public String getFiliacaoDistribuidor() {
		return filiacaoDistribuidor;
	}


	public String getCodVer() {
		return codVer;
	}


	public String getUrlBack() {
		return urlBack;
	}


	public String getUrlCima() {
		return urlCima;
	}


	public String getTarget() {
		return target;
	}


	public Bandeira getBandeira() {
		return checkout.getBandeira();
	}


	public String getNumeroDoPedido() {
		return checkout.getNumeroDoPedido();
	}


	public Parcelamento getParcelamento() {
		return checkout.getParcelamento();
	}


	public String getPax1() {
		return checkout.getPax1();
	}


	public BigDecimal getTotalComDuasCasasDecimais() {
		return checkout.getTotalComDuasCasasDecimais();
	}
	
	
	
	
	
	
	
}
