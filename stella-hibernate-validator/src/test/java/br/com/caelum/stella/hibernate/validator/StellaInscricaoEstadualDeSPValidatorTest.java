package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeSPValidatorTest {
    private StellaInscricaoEstadualDeSPValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualSP
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualSP ieSpAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualSP.class);
        validator = new StellaInscricaoEstadualDeSPValidator();
        validator.initialize(ieSpAnnotation);
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
            boolean valid = validator.isValid("P011004243002");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("110042490114");
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
