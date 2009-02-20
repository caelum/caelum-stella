package br.com.caelum.stella.hibernate.validator.xml.logic;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.Max;

final public class StellaMaxValidatorTest {

    @Test
    public void testThatNullIsValid() {
        StellaMaxValidator validator = new StellaMaxValidator();
        Assert.assertTrue(validator.isValid(null));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfFieldIsNotAnIntegerType() {
        StellaMaxValidator validator = new StellaMaxValidator();
        Assert.assertTrue(validator.isValid(""));
    }

    @Test
    public void testThatAcceptsOnlyByteShortIntegerAndLong() {
        StellaMaxValidator validator = new StellaMaxValidator();

        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));
        Assert.assertTrue(validator.isValid((byte) 10));
        Assert.assertTrue(validator.isValid((short) 10));
        Assert.assertTrue(validator.isValid(10));
        Assert.assertTrue(validator.isValid((long) 10));
    }

    @Test
    public void testThatIsInvalidIfValueIsBiggerThanAnnotatedValue() {
        StellaMaxValidator validator = new StellaMaxValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));

        Assert.assertFalse(validator.isValid(21));
    }

    @Test
    public void testThatIsValidIfValueIsEqualToAnnotatedValue() {
        StellaMaxValidator validator = new StellaMaxValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));

        Assert.assertTrue(validator.isValid(10));
    }

    public static class AnnotatedModel {
        @Max(20)
        public Byte b;
    }
}
