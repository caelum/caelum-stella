package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Fabio Kung
 */
public class StellaCPFValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        StellaCPFValidatorTag tag = new StellaCPFValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaCPFValidator);
    }
}
