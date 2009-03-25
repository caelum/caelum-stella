package br.com.caelum.stella.gateway.visa.integration;

import br.com.caelum.stella.gateway.visa.Checkout;
import br.com.caelum.stella.gateway.visa.BasicDataReturn;

public class VISAConsultaReturn implements VISAIntegrationReturn {

	private BasicDataReturn dadosBasicoDeRetorno;
	private Checkout checkout;
	private int authent;
	private String bank;

	public VISAConsultaReturn(BasicDataReturn dadosBasicoDeRetorno,
			Checkout checkout, int authent, String bank) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.checkout = checkout;
		this.authent = authent;
		this.bank = bank;
	}

	public Checkout getCheckout() {
		return checkout;
	}

	public int getAuthent() {
		return authent;
	}

	public String getBank() {
		return bank;
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
