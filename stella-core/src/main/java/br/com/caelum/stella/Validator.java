package br.com.caelum.stella;

import java.util.List;

/**
 * <p>
 * Validadores do Stella devem seguir essa inteface, que possui dois métodos
 * básicos. {@link #invalidMessagesFor(Object)} lista as mensagens de erro para
 * um determinado objeto. Já {@link #assertValid(Object)} verifica se o objeto
 * está ok, caso não seja válido ele lançará exceptions contendo
 * ValidationMessages.
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @author Paulo Silveira
 * @param <T>
 *            enum onde os tipos de erro estão declarados
 */
public interface Validator<T> {
	/**
	 * @param object
	 *            objeto que se desejar validar
	 */
	void assertValid(T object);

	/**
	 * @return lista com os problemas de validação relativos à esse objeto, ou
	 *         uma lista vazia (nao nula).
	 */
	List<ValidationMessage> getInvalidMessages(T object);
}
