package br.com.caelum.stella.hibernate.validator.xml.logic;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.xml.Length;

public class StellaLengthValidator implements Validator<Length> {

    private Length annotation;

    public void initialize(final Length annotation) {
        if (annotation.min() < 0) {
            throw new IllegalStateException("Min cannot be negative.");
        }

        if (annotation.max() < annotation.min()) {
            throw new IllegalStateException("Max cannot be smaller than min.");
        }

        this.annotation = annotation;
    }

    public boolean isValid(final Object object) {
        if (object == null) {
            return true;
        }

        if (!object.getClass().equals(String.class)) {
            throw new IllegalStateException(Length.class.getName()
                    + " can only be used to to annotate java.lang.String");
        }
        String val = object.toString();
        return (val.length() >= annotation.min()) && (val.length() <= annotation.max());
    }

}
