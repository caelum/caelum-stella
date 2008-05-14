package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeRRValidatorTest {
    private StellaInscricaoEstadualDeRRValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualRR
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualRR ieRRAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualRR.class);
        validator = new StellaInscricaoEstadualDeRRValidator();
        validator.initialize(ieRRAnnotation);
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
            boolean valid = validator.isValid("240066281");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("240017556");
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
