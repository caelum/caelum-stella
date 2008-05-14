package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeMTValidatorTest {
    private StellaInscricaoEstadualDeMTValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualMT
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualMT ieMTAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualMT.class);
        validator = new StellaInscricaoEstadualDeMTValidator();
        validator.initialize(ieMTAnnotation);
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
            boolean valid = validator.isValid("132466449");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("131988700");
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
