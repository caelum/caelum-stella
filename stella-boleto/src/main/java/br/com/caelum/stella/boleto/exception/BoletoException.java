package br.com.caelum.stella.boleto.exception;

public class BoletoException extends RuntimeException {

	public BoletoException(String message) {
		super(message);
	}

	public BoletoException() {
		super();
	}
}
