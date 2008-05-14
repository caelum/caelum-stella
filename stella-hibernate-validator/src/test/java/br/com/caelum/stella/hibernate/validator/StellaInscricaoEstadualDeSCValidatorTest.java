package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeSCValidatorTest {
    private StellaInscricaoEstadualDeSCValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualSC
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualSC ieSCAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualSC.class);
        validator = new StellaInscricaoEstadualDeSCValidator();
        validator.initialize(ieSCAnnotation);
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
            boolean valid = validator.isValid("251040852");
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
