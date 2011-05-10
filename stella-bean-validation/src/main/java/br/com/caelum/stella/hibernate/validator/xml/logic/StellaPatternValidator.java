package br.com.caelum.stella.hibernate.validator.xml.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.hibernate.validator.xml.Pattern;

public class StellaPatternValidator implements ConstraintValidator<Pattern, String> {

    private String pattern;

    public void initialize(final Pattern annotation) {
        pattern = annotation.value();
    }

	public boolean isValid(String toMatch, ConstraintValidatorContext arg1) {
        if (toMatch == null) {
            return true;
        }
        return java.util.regex.Pattern.compile(pattern).matcher(toMatch).matches();
	}

}
