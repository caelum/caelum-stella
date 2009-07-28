package br.com.caelum.stella.gateway.core;

import java.util.Calendar;

/**
 * Classe que mantem as informações de cartão de crédito.
 * 
 * @author Alberto Souza
 * 
 */
public class CartaoCredito {

	private long ccn;
	private Calendar exp;
	private int cvv2;

	public CartaoCredito(long ccn, Calendar exp, int cvv2) {
		super();
		this.ccn = ccn;
		this.exp = exp;
		this.cvv2 = cvv2;
	}

	public long getCcn() {
		return ccn;
	}

	public Calendar getExp() {
		return exp;
	}

	public int getCvv2() {
		return cvv2;
	}

	/**
	 * 
	 * @return Data de expiração do cartao formatada para aamm
	 */
	public String getExpFormatado() {
		return String.format("%1$tm%1$ty", this.exp);
	}

}
