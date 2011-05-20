package br.com.caelum.stella.bean.validation.xml.logic;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.Min;
import br.com.caelum.stella.bean.validation.xml.logic.StellaMinValidator;


@SuppressWarnings("deprecation")
final public class StellaMinValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

    @Test
    public void testThatNullIsValid() {
		StellaMinValidator validator = new StellaMinValidator();
        Assert.assertTrue(validator.isValid(null,context));
    }

    @Test
    public void testThatAcceptsOnlyByteShortIntegerAndLong() {
        StellaMinValidator validator = new StellaMinValidator();

        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));
        Assert.assertTrue(validator.isValid((byte) 20,context));
        Assert.assertTrue(validator.isValid((short) 20,context));
        Assert.assertTrue(validator.isValid(20,context));
        Assert.assertTrue(validator.isValid((long) 20,context));
    }

    @Test
    public void testThatIsInvalidIfValueIsLessThanAnnotatedValue() {
        StellaMinValidator validator = new StellaMinValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));

        Assert.assertFalse(validator.isValid(9,context));
    }

    @Test
    public void testThatIsValidIfValueIsEqualToAnnotatedValue() {
        StellaMinValidator validator = new StellaMinValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Min.class).atField("b"));

        Assert.assertTrue(validator.isValid(10,context));
    }

    public static class AnnotatedModel {
        @Min(10)
        public Byte b;
    }
}
