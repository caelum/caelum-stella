package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaCNPJValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        StellaCNPJValidatorTag tag = new StellaCNPJValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaCNPJValidator);
    }
}
