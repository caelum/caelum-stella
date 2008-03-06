package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        {
            boolean valid = validator.isValid("44474042000130");
            assertTrue(valid);
        }
    }

    @Test
    public void shouldValidateNull() {
        StellaCNPJValidator validator = new StellaCNPJValidator();
        boolean valid = validator.isValid(null);
        assertTrue(valid);
    }

    @Test
    public void shouldValidateEmpty() {
        StellaCNPJValidator validator = new StellaCNPJValidator();
        boolean valid = validator.isValid(null);
        assertTrue(valid);
    }

}
