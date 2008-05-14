package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaInscricaoEstadualDeROValidatorTest {
    private StellaInscricaoEstadualDeROValidator validator;

    private static class ObjectWithIE {
        @SuppressWarnings("unused")
		@InscricaoEstadualRO
        private String ie;
    }

    @Before
    public void createValidator() throws Exception {
    	InscricaoEstadualRO ieROAnnotation = ObjectWithIE.class.getDeclaredField("ie").getAnnotation(InscricaoEstadualRO.class);
        validator = new StellaInscricaoEstadualDeROValidator();
        validator.initialize(ieROAnnotation);
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
            boolean valid = validator.isValid("00000001721496");
            assertTrue(valid);
        }
        {
            boolean valid = validator.isValid("00000001721488");
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
