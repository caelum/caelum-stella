package br.com.caelum.stella;

import java.util.List;

/**
 * <p>
 * {@link #getInvalidMessages()} sempre devolve <b>apenas</b> os
 * problemas de validação relativos à última chamada de {@link #assertValid(Object)}
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @param <T>
 *            enum onde os tipos de erro estão declarados
 */
public interface Validator<T> {
	/**
	 * @param object
	 *            objeto que se desejar validar
	 * @return <code>false</code> caso algum erro de validação seja
	 *         encontrado; <code>true</code> caso contrário.
	 */
	void assertValid(T object);

	/**
	 * @return <b>apenas</b> os problemas de validação relativos à última
	 *         chamada de {@link #assertValid(Object)}
	 */
	List<ValidationMessage> invalidMessagesFor(T object);
}
