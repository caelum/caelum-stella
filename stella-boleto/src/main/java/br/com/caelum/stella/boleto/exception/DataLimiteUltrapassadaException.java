package br.com.caelum.stella.boleto.exception;

/**
 * Exception para quando é excedido range permito para criação de boletos
 * 
 * @author williamrodrigues
 *
 */
public class DataLimiteUltrapassadaException extends RuntimeException {
	private static final long serialVersionUID = -1590550038677531283L;

	public DataLimiteUltrapassadaException(String message, Exception e) {
		super(message, e);
	}

	public DataLimiteUltrapassadaException(Exception e) {
		super(e);
	}

	public DataLimiteUltrapassadaException(String message) {
		super(message);
	}
}
