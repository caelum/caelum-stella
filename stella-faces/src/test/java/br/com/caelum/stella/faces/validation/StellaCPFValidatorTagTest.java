package br.com.caelum.stella.faces.validation;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;
import javax.servlet.jsp.JspException;

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
