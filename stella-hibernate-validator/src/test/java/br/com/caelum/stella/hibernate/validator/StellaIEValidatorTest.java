package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTest {
    private StellaIEValidator validator;

    @IE
    private static class ObjectWithIE {
        @SuppressWarnings("unused")
        private String ie;

        @SuppressWarnings("unused")
        private String estado;

        private ObjectWithIE(String ie, String estado) {
            this.ie = ie;
            this.estado = estado;
        }

        public String getIe() {
            return ie;
        }

        public String getEstado() {
            return estado;
        }
    }

    @Before
    public void createValidator() throws Exception {
        IE ieAnnotation = ObjectWithIE.class.getAnnotation(IE.class);
        validator = new StellaIEValidator();
        validator.initialize(ieAnnotation);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenCantFindFielsInObject() {
        {
            boolean valid = validator.isValid(new Object());
            assertFalse(valid);
        }
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenValueIsNotAnObject() {
        {
            boolean valid = validator.isValid(14);
            assertFalse(valid);
        }
    }

    @Test
    public void shouldValidateObjectWithEstadoAndIE() {
        {
            boolean valid;
            valid = validator.isValid(new ObjectWithIE("P011004243002", "SP"));
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("2243658792", "RS"));
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("78045302", "RJ"));
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("041939808", "AM"));
            assertTrue(valid);
        }
    }

    @Test
    public void shouldValidateNull() {
        boolean valid = validator.isValid(null);
        assertTrue(valid);
    }

    @Test
    public void shouldNotValidateWhenEstadoIsMissing() {
        boolean valid = validator.isValid(new ObjectWithIE("P011004243002", ""));
        assertFalse(valid);
    }
    
    @Test
    public void shouldValidateEmpty() {
        boolean valid = validator.isValid(new ObjectWithIE("", "SP"));
        assertTrue(valid);
    }

}
