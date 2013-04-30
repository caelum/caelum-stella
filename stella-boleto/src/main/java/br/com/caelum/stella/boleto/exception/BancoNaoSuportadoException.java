package br.com.caelum.stella.boleto.exception;

public class BancoNaoSuportadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BancoNaoSuportadoException() {
		super();
	}

	public BancoNaoSuportadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BancoNaoSuportadoException(String message) {
		super(message);
	}
	
}
