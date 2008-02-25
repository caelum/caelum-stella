package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * @Author Leonardo Bessa
 */
public class StellaNITValidatorTest {

    @Test
    public void shouldOnlyValidateStrings() {
        StellaNITValidator validator = new StellaNITValidator();
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
