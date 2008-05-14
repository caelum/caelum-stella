package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDePRValidatorTest {
    private StellaInscricaoEstadualDePRValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualPR
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualPR iePRAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualPR.class);
        validator = new StellaInscricaoEstadualDePRValidator();
        validator.initialize(iePRAnnotation);
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
            boolean valid = validator.isValid("7380029469");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("7380033814");
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
