package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;

/**
 * <p>
 * {@link #invalidMessagesFor(Object))} devolve os problemas de
 * validação associado ao objeto.
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @param <T>
 *       tipo de objeto a ser validado
 */
public interface Validator<T> {
	/**
	 * @param object
	 *            objeto que se desejar validar
	 * @throws {@link InvalidStateException}
	 *             se o parametro não for válido
	 */
	void assertValid(T object);

	/**
	 * @return as mensagens de de validação relativas ao paremetro object
	 */
	List<ValidationMessage> invalidMessagesFor(T object);
}
