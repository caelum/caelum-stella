package br.com.caelum.stella.bean.validation.xml.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.xml.Length;
/**
 * @deprecated Anotação deste validador está obsoleta
 */
@Deprecated

public class StellaLengthValidator implements ConstraintValidator<Length, String> {

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

	public boolean isValid(final String val, ConstraintValidatorContext context) {
		if (val == null) {
			return true;
		}

		return (val.length() >= annotation.min()) && (val.length() <= annotation.max());
	}
}
