package br.com.caelum.stella.boleto;


public class GeracaoBoletoException extends BoletoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeracaoBoletoException(String message, Exception e) {
		super(message, e);
	}

	public GeracaoBoletoException(Exception e) {
		super(e);
	}

}
