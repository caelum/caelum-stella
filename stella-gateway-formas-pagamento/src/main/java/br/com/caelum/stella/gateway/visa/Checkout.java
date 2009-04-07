package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.gateway.core.CartaoCredito;
import br.com.caelum.stella.gateway.core.InvalidCheckoutException;
import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.visa.integration.TIDGenerator;

/**
 * Contém as informações necessárias para processar uma compra através do VISA
 * 
 * @author Alberto
 * 
 */
public class Checkout {

	/*
	 * Talvez seja bom validar todos os dados antes... mas ainda estou pensando
	 * nisso
	 */

	private String orderId;
	private String order;
	private String free;
	private BigDecimal price;
	private FormaPagamento parcelamento;
	private CartaoCredito cartao;	

	public Checkout(final String orderId, final String order,
			final String free, final BigDecimal price,
			final FormaPagamento parcelamento, final CartaoCredito cartao) {
		super();
		this.orderId = orderId;
		this.order = order;
		this.free = free;
		this.price = price;
		this.parcelamento = parcelamento;
		this.cartao = cartao;
	}
	
	public Checkout(final String orderId, final String order,
			final String free, final String unformattedPrice,
			final FormaPagamento parcelamento, final CartaoCredito cartao) {
		super();
		this.orderId = orderId;
		this.order = order;
		this.free = free;
		this.price = calculaPrecoDividoPorCem(unformattedPrice);
		this.parcelamento = parcelamento;
		this.cartao = cartao;
	}	

	
	private BigDecimal calculaPrecoDividoPorCem(String unformattedPrice) {
		return new BigDecimalFormatter().stringInCentsToBigDecimal(unformattedPrice);
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
	public FormaPagamento getParcelamento() {
		return parcelamento;
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
	public String getTid(Calendar data, String numeroDeAfiliacao) {
		return new TIDGenerator(this.parcelamento,data,numeroDeAfiliacao).getTid();

	}

}
