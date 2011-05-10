package br.com.caelum.stella.hibernate.validator.xml.logic;

import java.lang.reflect.Array;
import java.util.Collection;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.xml.MinElements;

public class StellaMinElementsValidator implements Validator<MinElements> {

    private MinElements annotation;

    public void initialize(final MinElements annotation) {
        if (annotation.value() < 0) {
            throw new IllegalStateException("Value cannot be negative.");
        }
        this.annotation = annotation;

    }

    public boolean isValid(final Object object) {
        if (object == null) {
            return true;
        }
        if (!Collection.class.isAssignableFrom(object.getClass()) && !object.getClass().isArray()) {
            throw new IllegalStateException(MinElements.class.getSimpleName()
                    + " can only be used to annotate a java.util.Collection or an Array.");
        }
        if (Collection.class.isAssignableFrom(object.getClass())
                && (Collection.class.cast(object).size() >= annotation.value())) {
            return true;
        }

        if (object.getClass().isArray() && (nonNullArrayElements(object) >= annotation.value())) {
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
