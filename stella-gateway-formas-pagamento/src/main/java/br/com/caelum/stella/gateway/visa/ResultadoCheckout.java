package br.com.caelum.stella.gateway.visa;

public class ResultadoCheckout {

	private String lr;
	private String arp;
	private String pan;
	private String ars;
	private Checkout checkout;
	
	public ResultadoCheckout(final String lr, final String arp, final String pan,
			final String ars, Checkout checkout) {
		super();
		this.lr = lr;
		this.arp = arp;		
		this.pan = pan;
		this.ars = ars;
		this.checkout = checkout;
	}

	public String getLr() {
		return lr;
	}

	public void setLr(String lr) {
		this.lr = lr;
	}

	public String getArp() {
		return arp;
	}

	public void setArp(String arp) {
		this.arp = arp;
	}



	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getArs() {
		return ars;
	}

	public void setArs(String ars) {
		this.ars = ars;
	}
	

	
	
	
	
}
