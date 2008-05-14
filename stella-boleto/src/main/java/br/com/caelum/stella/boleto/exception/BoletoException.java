package br.com.caelum.stella.boleto.exception;

public class BoletoException extends RuntimeException {

	public BoletoException(String message, Exception e) {
		super(message, e);
	}

	public BoletoException(Exception e) {
		super(e);
	}
}
