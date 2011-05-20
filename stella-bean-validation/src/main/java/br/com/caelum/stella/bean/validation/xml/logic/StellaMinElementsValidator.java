package br.com.caelum.stella.bean.validation.xml.logic;

import java.lang.reflect.Array;
import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.xml.MinElements;
/**
 * @deprecated Anotação deste validador está obsoleta
 */
@Deprecated

public class StellaMinElementsValidator implements ConstraintValidator<MinElements, Object> {

    private MinElements annotation;

    public void initialize(final MinElements annotation) {
        if (annotation.value() < 0) {
            throw new IllegalStateException("Value cannot be negative.");
        }
        this.annotation = annotation;

    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
    	if (value == null) {
    		return true;
    	}
    	if (!Collection.class.isAssignableFrom(value.getClass()) && !value.getClass().isArray()) {
    		throw new IllegalStateException(MinElements.class.getSimpleName()
    				+ " can only be used to annotate a java.util.Collection or an Array.");
    	}
    	if (Collection.class.isAssignableFrom(value.getClass())
    			&& (Collection.class.cast(value).size() >= annotation.value())) {
    		return true;
    	}
    	
    	if (value.getClass().isArray() && (nonNullArrayElements(value) >= annotation.value())) {
    		return true;
    	}
    	
    	return false;
    }

    private long nonNullArrayElements(final Object arg0) {
        int cont = 0;
        if (!Object[].class.isAssignableFrom(arg0.getClass())) {
            throw new IllegalStateException(MinElements.class.getSimpleName()
                    + " cannot be used to annotate an array of primitive types.");
        }
        for (int i = 0; i < Array.getLength(arg0); i++) {
            if (Array.get(arg0, i) != null) {
                cont++;
            }
        }
        return cont;
    }

}
