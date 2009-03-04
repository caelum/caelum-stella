package br.com.caelum.stella.gateway.core;

/**
 * Informa quando um checkout está em estado invalido.
 * @author Alberto Pc
 *
 */
public class CheckoutInvalidoException extends RuntimeException {

	public CheckoutInvalidoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CheckoutInvalidoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
}
