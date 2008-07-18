package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        StellaIEValidatorTag tag = new StellaIEValidatorTag();
        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaIEValidator);
    }
}
