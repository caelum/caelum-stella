package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.hibernate.validator.logic.StellaIEValidator;

/**
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
    private StellaIEValidator validator;

    @IE
    private static class ObjectWithIE {
        private final String ie;

        private final String estado;

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
            boolean valid = validator.isValid(new Object(),context);
            assertFalse(valid);
        }
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenValueIsNotAnObject() {
        {
            boolean valid = validator.isValid(14,context);
            assertFalse(valid);
        }
    }

    @Test
    public void shouldValidateObjectWithEstadoAndIE() {
        {
            boolean valid;
            valid = validator.isValid(new ObjectWithIE("P011004243002", "SP"),context);
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("2243658792", "RS"),context);
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("78045302", "RJ"),context);
            assertTrue(valid);
            valid = validator.isValid(new ObjectWithIE("041939808", "AM"),context);
            assertTrue(valid);
        }
    }

    @Test
    public void shouldValidateNull() {
        boolean valid = validator.isValid(null,context);
        assertTrue(valid);
    }

    @Test
    public void shouldNotValidateWhenEstadoIsMissing() {
        boolean valid = validator.isValid(new ObjectWithIE("P011004243002", ""),context);
        assertFalse(valid);
    }

    @Test
    public void shouldValidateEmpty() {
        boolean valid = validator.isValid(new ObjectWithIE("", "SP"),context);
        assertTrue(valid);
    }

}
