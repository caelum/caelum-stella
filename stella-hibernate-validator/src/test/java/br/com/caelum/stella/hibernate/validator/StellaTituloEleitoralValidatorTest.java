package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.logic.StellaTituloEleitoralValidator;

/**
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidatorTest {
    private StellaTituloEleitoralValidator validator;

    private static class ObjectWithTituloEleitoral {
        @SuppressWarnings("unused")
        @TituloEleitoral
        private String tituloEleitoral;
    }

    @Before
    public void createValidator() throws Exception {
        TituloEleitoral tituloEleitoralAnnotation = ObjectWithTituloEleitoral.class.getDeclaredField("tituloEleitoral").getAnnotation(TituloEleitoral.class);
        validator = new StellaTituloEleitoralValidator();
        validator.initialize(tituloEleitoralAnnotation);
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
            boolean valid = validator.isValid("253346440540");
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
