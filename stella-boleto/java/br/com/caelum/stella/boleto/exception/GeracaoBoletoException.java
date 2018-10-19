package br.com.caelum.stella.boleto.exception;

/**
 * Representa um erro ao gerar um boleto para PNG, JPEG, PDF, etc. Normalmente
 * representa um erro na camada responsável por gerar nesse formato específico.
 * 
 * 
 */
public class GeracaoBoletoException extends BoletoException {

	private static final long serialVersionUID = 1L;

	public GeracaoBoletoException(String message, Exception e) {
		super(message, e);
	}

	public GeracaoBoletoException(Exception e) {
		super(e);
	}

}
