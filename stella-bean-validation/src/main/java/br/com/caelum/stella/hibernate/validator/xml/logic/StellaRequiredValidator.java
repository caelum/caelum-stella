package br.com.caelum.stella.hibernate.validator.xml.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.hibernate.validator.xml.Required;

public class StellaRequiredValidator implements
		ConstraintValidator<Required, Object> {

	public void initialize(final Required annotation) {
	}

	public boolean isValid(Object object, ConstraintValidatorContext context) {
		return object != null;
	}

}
