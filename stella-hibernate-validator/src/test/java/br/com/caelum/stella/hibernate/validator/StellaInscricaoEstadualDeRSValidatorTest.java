package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeRSValidatorTest {
    private StellaInscricaoEstadualDeRSValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualRS
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualRS ieRSAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualRS.class);
        validator = new StellaInscricaoEstadualDeRSValidator();
        validator.initialize(ieRSAnnotation);
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
            boolean valid = validator.isValid("2243658792");
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
