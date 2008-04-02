package br.com.caelum.stella;

import java.util.List;

/**
 * <p>
 * {@link #getLastValidationMessages()} sempre devolve <b>apenas</b> os
 * problemas de validação relativos à última chamada de {@link #validate(Object)}
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
	boolean validate(T object);

	/**
	 * @return <b>apenas</b> os problemas de validação relativos à última
	 *         chamada de {@link #validate(Object)}
	 */
	List<ValidationMessage> getLastValidationMessages();
}
