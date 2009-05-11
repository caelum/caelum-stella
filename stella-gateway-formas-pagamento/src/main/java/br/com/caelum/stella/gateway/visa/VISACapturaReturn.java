package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;


public class VISACapturaReturn implements VISAIntegrationReturn {
	
	private VISABasicDataReturn dadosBasicoDeRetorno;
	private BigDecimal cap;	
	public VISACapturaReturn(VISABasicDataReturn dadosBasicoDeRetorno,
			BigDecimal cap) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.cap = cap;		
	}
	public BigDecimal getCap() {
		return cap;
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
