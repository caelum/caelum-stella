package br.com.caelum.stella.hibernate.validator.xml.logic;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.xml.Min;

final public class StellaMinValidator implements Validator<Min> {

    private Min annotation;

    @SuppressWarnings("unchecked")
    private final List<Class<?>> acceptedTypes = (List) Arrays.asList(Byte.class, Short.class, Integer.class,
            Long.class);

    public void initialize(final Min annotation) {
        this.annotation = annotation;

    }

    public boolean isValid(final Object object) {
        if (object == null) {
            return true;
        }
        if (!acceptedTypes.contains(object.getClass())) {
            throw new IllegalStateException(Min.class.getSimpleName() + " cannot be used to annotate a field of type "
                    + object.getClass().getName() + ". Only Byte, Short, Integer and Long are accepted.");
        }

        Long val = new Long(object.toString());

        if (val < annotation.value()) {
            return false;
        }

        return true;
    }
}
