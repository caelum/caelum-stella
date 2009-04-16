package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;


public class VISAConsultaReturn implements VISAIntegrationReturn {

	private VISABasicDataReturn dadosBasicoDeRetorno;
	private VISACheckout checkout;
	private int authent;
	private int bank;	

	public VISAConsultaReturn(VISABasicDataReturn dadosBasicoDeRetorno,
			VISACheckout checkout, int authent, int bank) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.checkout = checkout;
		this.authent = authent;
		this.bank = bank;		
	}

	

	public String getFree() {
		return checkout.getFree();
	}



	public String getOrderId() {
		return checkout.getOrderId();
	}



	public BigDecimal getPrice() {
		return checkout.getPrice();
	}



	public String getValorFormatado() {
		return checkout.getValorFormatado();
	}



	public int getAuthent() {
		return authent;
	}

	public int getBank() {
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
