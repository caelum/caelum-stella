package br.com.caelum.stella.boleto;

public class BoletoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoletoException(String message, Exception e) {
		super(message, e);
	}

	public BoletoException(Exception e) {
		super(e);
	}
}
