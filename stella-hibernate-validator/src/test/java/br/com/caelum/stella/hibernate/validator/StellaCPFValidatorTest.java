package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * @Author Fabio Kung
 */
public class StellaCPFValidatorTest {

    @Test
    public void shouldOnlyValidateStrings() {
        StellaCPFValidator validator = new StellaCPFValidator();
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
