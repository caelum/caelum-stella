package br.com.caelum.stella.bean.validation.xml.logic;

import java.lang.reflect.Array;
import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.xml.MaxElements;

/**
 * @deprecated Anotação deste validador está obsoleta
 */
@Deprecated

public class StellaMaxElementsValidator implements ConstraintValidator<MaxElements, Object> {

    private MaxElements annotation;

    public void initialize(final MaxElements annotation) {
        if (annotation.value() < 0) {
            throw new IllegalStateException("Value cannot be negative.");
        }
        this.annotation = annotation;

    }

    public boolean isValid(final Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true;
        }
        if (!Collection.class.isAssignableFrom(object.getClass()) && !object.getClass().isArray()) {
            throw new IllegalStateException(MaxElements.class.getSimpleName()
                    + " can only be used to annotate a java.util.Collection or an Array.");
        }
        if (Collection.class.isAssignableFrom(object.getClass())
                && (Collection.class.cast(object).size() <= annotation.value())) {
            return true;
        }

        if (object.getClass().isArray() && (nonNullArrayElements(object) <= annotation.value())) {
            return true;
        }

        return false;
    }

    private long nonNullArrayElements(final Object array) {
        int cont = 0;
        if (!Object[].class.isAssignableFrom(array.getClass())) {
            throw new IllegalStateException(MaxElements.class.getSimpleName()
                    + " cannot be used to annotate an array of primitive types.");
        }
        for (int i = 0; i < Array.getLength(array); i++) {
            if (Array.get(array, i) != null) {
                cont++;
            }
        }
        return cont;
    }
}
