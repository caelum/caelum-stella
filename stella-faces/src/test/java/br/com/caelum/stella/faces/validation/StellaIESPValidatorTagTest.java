package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaIESPValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
    	StellaIESPValidatorTag tag = new StellaIESPValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaIESPValidator);
    }
}
