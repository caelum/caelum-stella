package br.com.caelum.stella;

import java.util.List;

/**
 * Base interface for all validators.
 *
 * @Author Fabio Kung
 */
public interface Validator<T> {
    List<ValidationError> validate(T object);
}
