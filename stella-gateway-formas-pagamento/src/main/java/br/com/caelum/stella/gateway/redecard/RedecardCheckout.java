package br.com.caelum.stella.gateway.redecard;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RedecardCheckout {

	private BigDecimal total;
	private RedecardFormaPagamento formaPagamento;
	private RedecardBandeira bandeira;
	private String numeroDoPedido;
	private String pax1;

	public RedecardCheckout(BigDecimal total,
			RedecardFormaPagamento formaPagamento, RedecardBandeira bandeira,
			String numeroDoPedido, String pax1) {
		super();
		this.total = total;
		this.formaPagamento = formaPagamento;
		this.bandeira = bandeira;
		this.numeroDoPedido = numeroDoPedido;
		this.pax1 = pax1;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public RedecardFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public RedecardBandeira getBandeira() {
		return bandeira;
	}

	public String getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public String getPax1() {
		return pax1;
	}

	public BigDecimal getTotalComDuasCasasDecimais() {
		return total.setScale(2, RoundingMode.HALF_EVEN);
	}

}
