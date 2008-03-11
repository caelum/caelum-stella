package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaNITValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        StellaNITValidatorTag tag = new StellaNITValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaNITValidator);
    }
}
