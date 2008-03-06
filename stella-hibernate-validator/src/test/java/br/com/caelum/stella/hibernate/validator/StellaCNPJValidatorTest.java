package br.com.caelum.stella.hibernate.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

/**
 * @Author Leonardo Bessa
 */
public class StellaCNPJValidatorTest {
    private StellaCNPJValidator validator;

    private static class ObjectWithCNPJ {
        @CNPJ
        private String cnpj;
    }

    @Before
    public void createValidator() throws Exception {
        CNPJ cnpjAnnotation = ObjectWithCNPJ.class.getDeclaredField("cnpj").getAnnotation(CNPJ.class);
        validator = new StellaCNPJValidator();
        validator.initialize(cnpjAnnotation);
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
            boolean valid = validator.isValid("44474042000130");
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
