package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

/**
 * @Author Leonardo Bessa
 */
public class StellaNITValidatorTest {

    private StellaNITValidator validator;

    private static class ObjectWithNIT {
        @NIT
        private String nit;
    }

    @Before
    public void createValidator() throws Exception {
        NIT nitAnnotation = ObjectWithNIT.class.getDeclaredField("nit").getAnnotation(NIT.class);
        validator = new StellaNITValidator();
        validator.initialize(nitAnnotation);
    }

    @Test
    public void shouldOnlyValidateStrings() {
        {
            boolean valid = validator.isValid(new Object());
            assertFalse(valid);
        }
        {
            boolean valid = validator.isValid(14);
            assertFalse(valid);
        }
        {
            boolean valid = validator.isValid("34608514300");
            assertTrue(valid);
        }
    }

    @Test
    public void shouldValidateNull() {
        boolean valid = validator.isValid(null);
        assertTrue(valid);
    }

    @Test
    public void shouldValidateEmpty() {
        boolean valid = validator.isValid("");
        assertTrue(valid);
    }
}
