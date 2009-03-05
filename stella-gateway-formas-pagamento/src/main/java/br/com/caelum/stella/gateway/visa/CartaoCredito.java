package br.com.caelum.stella.gateway.visa;

import java.util.Calendar;

public class CartaoCredito {

	private String ccn;
	private Calendar exp;
	private String cvv2;
	
	
	
	public CartaoCredito(String ccn, Calendar exp, String cvv2) {
		super();
		this.ccn = ccn;
		this.exp = exp;
		this.cvv2 = cvv2;
	}
	public String getCcn() {
		return ccn;
	}
	public Calendar getExp() {
		return exp;
	}
	public String getCvv2() {
		return cvv2;
	}
	
	/**
	 * Data de expiração do cartao formatada para aamm
	 * @return
	 */
	public String getFormattedExp(){
		return String.format("%1$tm%1$ty",this.exp);
	}	
	
}
