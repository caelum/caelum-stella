package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Fabio Kung
 */
public class StellaCPFValidatorTest {
    private StellaCPFValidator validator;

    private static class ObjectWithCPF {
        @SuppressWarnings("unused")
        @CPF
        private String cpf;
    }

    @Before
    public void createValidator() throws Exception {
        CPF cpfAnnotation = ObjectWithCPF.class.getDeclaredField("cpf").getAnnotation(CPF.class);
        validator = new StellaCPFValidator();
        validator.initialize(cpfAnnotation);
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
            boolean valid = validator.isValid("03118383402");
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
