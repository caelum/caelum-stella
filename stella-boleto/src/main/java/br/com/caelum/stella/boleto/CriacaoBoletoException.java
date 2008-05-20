package br.com.caelum.stella.boleto;

/**
 * Representa um erro ao pegar dados de um boleto.
 * 
 */
public class CriacaoBoletoException extends BoletoException {

    private static final long serialVersionUID = 1L;

    public CriacaoBoletoException(String message, Exception e) {
        super(message, e);
    }

    public CriacaoBoletoException(Exception e) {
        super(e);
    }

}
