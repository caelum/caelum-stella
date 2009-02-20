package br.com.caelum.stella.hibernate.validator.xml.logic;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.Min;

final public class StellaMinValidatorTest {

    @Test
    public void testThatNullIsValid() {
        StellaMinValidator validator = new StellaMinValidator();
        Assert.assertTrue(validator.isValid(null));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfFieldIsNotAnIntegerType() {
        StellaMinValidator validator = new StellaMinValidator();
        Assert.assertTrue(validator.isValid(""));
    }

    @Test
    public void testThatAcceptsOnlyByteShortIntegerAndLong() {
        StellaMinValidator validator = new StellaMinValidator();

        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));
        Assert.assertTrue(validator.isValid((byte) 20));
        Assert.assertTrue(validator.isValid((short) 20));
        Assert.assertTrue(validator.isValid(20));
        Assert.assertTrue(validator.isValid((long) 20));
    }

    @Test
    public void testThatIsInvalidIfValueIsLessThanAnnotatedValue() {
        StellaMinValidator validator = new StellaMinValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));

        Assert.assertFalse(validator.isValid(9));
    }

    @Test
    public void testThatIsValidIfValueIsEqualToAnnotatedValue() {
        StellaMinValidator validator = new StellaMinValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));

        Assert.assertTrue(validator.isValid(10));
    }

    public static class AnnotatedModel {
        @Min(10)
        public Byte b;
    }
}
