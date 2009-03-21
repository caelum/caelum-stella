package br.com.caelum.stella.gateway.redecard;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Checkout {

	private BigDecimal total;
	private Parcelamento parcelamento;
	private Bandeira bandeira;
	private String numeroDoPedido;
	private String pax1;
	

	public Checkout(final BigDecimal total, final Parcelamento parcelamento,
			final Bandeira bandeira, final String numeroDoPedido, final String pax1) {
		super();
		this.total = total;
		this.parcelamento = parcelamento;
		this.bandeira = bandeira;
		this.numeroDoPedido = numeroDoPedido;
		this.pax1 = pax1;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public Parcelamento getParcelamento() {
		return parcelamento;
	}


	public Bandeira getBandeira() {
		return bandeira;
	}


	public String getNumeroDoPedido() {
		return numeroDoPedido;
	}


	public String getPax1() {
		return pax1;
	}
	
	
	public BigDecimal getTotalComDuasCasasDecimais(){
		return total.setScale(2,RoundingMode.HALF_EVEN);
	}
	
	
	
	
}
