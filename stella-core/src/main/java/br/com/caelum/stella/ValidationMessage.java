package br.com.caelum.stella;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * Mensagens de erro sobre a validação de um objeto devem implementar essa
 * interface.
 * 
 * @author Fabio Kung
 */
@GwtCompatible
public interface ValidationMessage {
    /**
     * @return mensagem de validação armazenda.
     */
    String getMessage();
}
