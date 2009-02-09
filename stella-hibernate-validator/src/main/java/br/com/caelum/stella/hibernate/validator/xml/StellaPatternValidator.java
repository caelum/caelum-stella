package br.com.caelum.stella.hibernate.validator.xml;

import org.hibernate.validator.Validator;

public class StellaPatternValidator implements Validator<Pattern> {

    private String pattern;

    public void initialize(final Pattern annotation) {
        pattern = annotation.value();
    }

    public boolean isValid(final Object toMatch) {
        if (toMatch == null) {
            return true;
        }
        if (!String.class.equals(toMatch.getClass())) {
            throw new IllegalStateException(Pattern.class.getName()
                    + " can only be used to annotate a field of type java.lang.String. Cannot aply pattern to "
                    + toMatch.getClass().getName());
        }
        return java.util.regex.Pattern.compile(pattern).matcher(toMatch.toString()).matches();
    }

}
