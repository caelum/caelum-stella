package br.com.caelum.stella.bean.validation.xml.logic;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.Max;
import br.com.caelum.stella.bean.validation.xml.logic.StellaMaxValidator;

@SuppressWarnings("deprecation")
final public class StellaMaxValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

    @Test
    public void testThatNullIsValid() {
		StellaMaxValidator validator = new StellaMaxValidator();
        Assert.assertTrue(validator.isValid(null,context));
    }

    @Test
    public void testThatAcceptsOnlyByteShortIntegerAndLong() {
        StellaMaxValidator validator = new StellaMaxValidator();

        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));
        Assert.assertTrue(validator.isValid((byte) 10,context));
        Assert.assertTrue(validator.isValid((short) 10,context));
        Assert.assertTrue(validator.isValid(10,context));
        Assert.assertTrue(validator.isValid((long) 10,context));
    }

    @Test
    public void testThatIsInvalidIfValueIsBiggerThanAnnotatedValue() {
        StellaMaxValidator validator = new StellaMaxValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));

        Assert.assertFalse(validator.isValid(21,context));
    }

    @Test
    public void testThatIsValidIfValueIsEqualToAnnotatedValue() {
        StellaMaxValidator validator = new StellaMaxValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Max.class).atField("b"));

        Assert.assertTrue(validator.isValid(10,context));
    }

    public static class AnnotatedModel {
        @Max(20)
        public Byte b;
    }
}
