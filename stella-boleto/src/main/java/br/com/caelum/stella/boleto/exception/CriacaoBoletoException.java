package br.com.caelum.stella.boleto.exception;

public class CriacaoBoletoException extends BoletoException {

	public CriacaoBoletoException(String message, Exception e) {
		super(message, e);
	}

	public CriacaoBoletoException(Exception e) {
		super(e);
	}

}
