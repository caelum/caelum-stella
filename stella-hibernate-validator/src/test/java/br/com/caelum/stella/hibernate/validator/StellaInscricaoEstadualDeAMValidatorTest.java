package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeAMValidatorTest {
    private StellaInscricaoEstadualDeAMValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualAM
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualAM ieAMAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualAM.class);
        validator = new StellaInscricaoEstadualDeAMValidator();
        validator.initialize(ieAMAnnotation);
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
            boolean valid = validator.isValid("041939808");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("041330471");
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
