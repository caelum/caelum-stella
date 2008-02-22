package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * @Author Leonardo Bessa
 */
public class StellaCNPJValidatorTest {

    @Test
    public void shouldOnlyValidateStrings() {
        StellaCNPJValidator validator = new StellaCNPJValidator();
        {
            boolean valid = validator.isValid(new Object());
            assertFalse(valid);
        }
        {
            boolean valid = validator.isValid(14);
            assertFalse(valid);
        }
    }
}
