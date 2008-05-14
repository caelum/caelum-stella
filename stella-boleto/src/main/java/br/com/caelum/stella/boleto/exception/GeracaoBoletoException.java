package br.com.caelum.stella.boleto.exception;

public class GeracaoBoletoException extends BoletoException {

	public GeracaoBoletoException(String message, Exception e) {
		super(message, e);
	}

	public GeracaoBoletoException(Exception e) {
		super(e);
	}

}
