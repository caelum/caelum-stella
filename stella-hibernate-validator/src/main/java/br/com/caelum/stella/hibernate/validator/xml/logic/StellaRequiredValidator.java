package br.com.caelum.stella.hibernate.validator.xml.logic;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.xml.Required;

public class StellaRequiredValidator implements Validator<Required> {

    public void initialize(final Required annotation) {
    }

    public boolean isValid(final Object object) {
        return object != null;
    }

}
