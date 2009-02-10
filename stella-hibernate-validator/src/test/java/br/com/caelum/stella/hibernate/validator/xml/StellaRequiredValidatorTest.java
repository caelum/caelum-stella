package br.com.caelum.stella.hibernate.validator.xml;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaRequiredValidator;

public class StellaRequiredValidatorTest {

    @Test
    public void testThatNullIsInvalid() {
        StellaRequiredValidator validator = new StellaRequiredValidator();
        Assert.assertFalse(validator.isValid(null));
    }

    @Test
    public void testThatAnyReferenceIsValid() {
        StellaRequiredValidator validator = new StellaRequiredValidator();
        Assert.assertTrue(validator.isValid(new Object()));
    }
}
