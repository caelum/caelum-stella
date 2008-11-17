package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        StellaTituloEleitoralValidatorTag tag = new StellaTituloEleitoralValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaTituloEleitoralValidator);
    }
}
