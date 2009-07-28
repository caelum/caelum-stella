package br.com.caelum.stella.gateway.core;

/**
 * Exception que deve ser lançada quando um checkout está em estado invalido.
 * @author Alberto Pc
 *
 */
public class InvalidCheckoutException extends RuntimeException {

	public InvalidCheckoutException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCheckoutException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
}
