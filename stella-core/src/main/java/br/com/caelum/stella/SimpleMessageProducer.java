package br.com.caelum.stella;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * <p>
 * SimpleMessageProducer é responsável pela geração de mensagens de erro. Estas
 * mensagens são geradas atraves dos nomes das anotoções que representam os
 * erros.
 * </p>
 * <p>
 * A messagem de erro é composta do seguinte modo:
 * </p>
 * <code>
 * String message = (simpleName + "." + errorName).replaceFirst("[.]", " : ").replaceAll("_", " "); 
 * </code> 
 * 
 * <p>
 * Veja o exemplo:
 * </p>
 * <p>
 * A mesagem do erro representado por CPFError.INVALID_DIGITS é : <br>
 * CPFError : INVALID DIGITS .
 * </p>
 * 
 * @author Leonardo Bessa
 * 
 */
public class SimpleMessageProducer implements MessageProducer {

    /**
     * @see MessageProducer#getMessage(InvalidValue)
     */
    public ValidationMessage getMessage(InvalidValue error) {
        String simpleName = error.getClass().getSimpleName();
        String errorName = error.name();
        String key = simpleName + "." + errorName;
        String message;
        message = key.replaceFirst("[.]", " : ").replaceAll("_", " ");
        return new SimpleValidationMessage(message);
    }
}
