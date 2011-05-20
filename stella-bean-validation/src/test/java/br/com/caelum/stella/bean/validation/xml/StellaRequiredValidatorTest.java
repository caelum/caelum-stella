package br.com.caelum.stella.bean.validation.xml;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.logic.StellaRequiredValidator;

@SuppressWarnings("deprecation")
public class StellaRequiredValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

    @Test
    public void testThatNullIsInvalid() {
		StellaRequiredValidator validator = new StellaRequiredValidator();
        Assert.assertFalse(validator.isValid(null,context));
    }

    @Test
    public void testThatAnyReferenceIsValid() {
        StellaRequiredValidator validator = new StellaRequiredValidator();
        Assert.assertTrue(validator.isValid(new Object(),context));
    }
}
