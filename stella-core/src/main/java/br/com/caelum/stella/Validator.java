package br.com.caelum.stella;

import java.util.List;

/**
 * <p>
 * {Validator#getLastValidationMessages} sempre devolve <b>apenas</b> os
 * problemas de validação relativos à última chamada de {Validator#validate}
 * </p>
 *
 * @Author Fabio Kung
 */
public interface Validator<T> {
    boolean validate(T object);
    List<ValidationMessage> getLastValidationMessages();
}
