package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.gateway.core.CartaoCredito;
import br.com.caelum.stella.gateway.core.InvalidCheckoutException;
import br.com.caelum.stella.gateway.core.BigDecimalFormatter;

/**
 * Contém as informações necessárias para processar uma compra através do VISA
 * 
 * @author Alberto
 * 
 */
public class VISACheckout {

	private String orderId;
	private String order;
	private String free;
	private BigDecimal price;
	private VISAFormaPagamento formaPagamento;
	private CartaoCredito cartao;

	public VISACheckout(String orderId, String order, String free,
			BigDecimal price, VISAFormaPagamento formaPagamento,
			CartaoCredito cartao) {
		super();
		this.orderId = orderId;
		this.order = order;
		this.free = free;
		this.price = price;
		this.formaPagamento = formaPagamento;
		this.cartao = cartao;
	}

	VISACheckout(String orderId, String order, String free,
			String unformattedPrice, VISAFormaPagamento formaPagamento,
			CartaoCredito cartao) {
		super();
		this.orderId = orderId;
		this.order = order;
		this.free = free;
		this.price = calculaPrecoDividoPorCem(unformattedPrice);
		this.formaPagamento = formaPagamento;
		this.cartao = cartao;
	}

	private BigDecimal calculaPrecoDividoPorCem(String unformattedPrice) {
		return new BigDecimalFormatter()
				.stringInCentsToBigDecimal(unformattedPrice);
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	/**
	 * 
	 * @return preço formatado em centésimos.
	 */
	public String getValorFormatado() {
		return new BigDecimalFormatter().bigDecimalToStringInCents(this.price);
	}

	/**
	 * informacoes de parcelamento do checkout
	 * 
	 * @return
	 */
	public VISAFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * Retorna a descricao completa da compra, referente ao campo oficial order
	 * 
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Campo livre, qualquer informacao adicional que queria ser
	 * disponibilizada.
	 * 
	 * @return
	 */
	public String getFree() {
		return free;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * identificador unico gerado para cada compra.
	 * 
	 * @param data
	 *            data que serve de referencia para o calculo do tid
	 * @param numeroDeAfiliacao
	 *            numeroDeAfiliacao que serve de base para o calculo.
	 * @return
	 * @throws InvalidCheckoutException
	 *             caso o parcelamento não tenha sido definido
	 */
	public String getTid(Calendar data, long numeroDeAfiliacao) {
		return new TIDGenerator()
				.getTid(this.formaPagamento, data, numeroDeAfiliacao);

	}

}
