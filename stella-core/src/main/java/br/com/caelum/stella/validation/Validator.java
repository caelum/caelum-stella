package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;

/**
 * <p>
 * Interface que os validadores do Stella devem implementar.
 * 
 * {@link #invalidMessagesFor(Object))} devolve os problemas de validação
 * associado ao objeto.
 * 
 * {@link #assertValid(Object))} valida o objeto e lança uma exception no caso
 * inválido.
 * 
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @param <T>
 *            tipo de objeto a ser validado
 */
public interface Validator<T> {
    /**
     * @param object
     *            objeto que se deseja validar
     * @throws {@link InvalidStateException} se o parametro não for válido,
     *         contendo a lista de ValidationMessage
     */
    void assertValid(T object);

    /**
     * @return as mensagens de de validação relativas ao paremetro object
     */
    List<ValidationMessage> invalidMessagesFor(T object);

    /**
     * @param object
     *            objeto que se deseja avaliar
     * @return <code>true</code> se o objeto é elegível para a validação por
     *         este validador, e <code>false</code> caso contrário
     */
    boolean isEligible(T object);

}
