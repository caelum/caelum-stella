package br.com.caelum.stella.gateway.visa.integration;

import java.math.BigDecimal;

import br.com.caelum.stella.gateway.visa.BasicDataReturn;

public class VISACapturaReturn implements VISAIntegrationReturn {
	
	private BasicDataReturn dadosBasicoDeRetorno;
	private BigDecimal cap;
	private String free;
	public VISACapturaReturn(BasicDataReturn dadosBasicoDeRetorno,
			BigDecimal cap, String free) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.cap = cap;
		this.free = free;
	}
	public BigDecimal getCap() {
		return cap;
	}
	public String getFree() {
		return free;
	}
	public String getArs() {
		return dadosBasicoDeRetorno.getArs();
	}
	public int getLr() {
		return dadosBasicoDeRetorno.getLr();
	}
	public String getTid() {
		return dadosBasicoDeRetorno.getTid();
	}
	
	
	
}
