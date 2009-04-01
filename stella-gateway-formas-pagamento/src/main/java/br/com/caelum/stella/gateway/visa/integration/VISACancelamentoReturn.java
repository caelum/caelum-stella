package br.com.caelum.stella.gateway.visa.integration;

import java.math.BigDecimal;


public class VISACancelamentoReturn implements VISAIntegrationReturn {

	private VISABasicDataReturn dadosBasicoDeRetorno;
	private BigDecimal cancel_amount;
	private String free;
	
	public VISACancelamentoReturn(VISABasicDataReturn dadosBasicoDeRetorno,
			BigDecimal cancel_amount, String free) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.cancel_amount = cancel_amount;
		this.free = free;
	}

	public BigDecimal getCancel_amount() {
		return cancel_amount;
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
