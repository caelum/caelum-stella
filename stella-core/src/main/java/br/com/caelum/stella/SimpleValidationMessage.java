package br.com.caelum.stella;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * Implementação básica e imutável. Apenas guarda a mensagem.
 * 
 * @author Fabio Kung
 */
@GwtCompatible
public class SimpleValidationMessage implements ValidationMessage {
    private final String message;

    public SimpleValidationMessage(String message) {
        this.message = message;
    }

    /**
     * @see br.com.caelum.stella.ValidationMessage#getMessage()
     */
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public String toString() {
    	return this.getMessage();
    }
}
