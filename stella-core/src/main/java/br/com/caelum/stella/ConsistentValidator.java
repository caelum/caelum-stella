package br.com.caelum.stella;

import br.com.caelum.stella.validation.Validator;

public interface ConsistentValidator<T> extends Validator<T> {
    
    boolean patternMatches(T value);

}
