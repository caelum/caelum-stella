package br.com.caelum.stella.bean.validation.xml;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.Length;
import br.com.caelum.stella.bean.validation.xml.logic.StellaLengthValidator;

@SuppressWarnings("deprecation")
public class StellaLengthValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

	@Test
	public void testThatNullIsValid() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("foo"));
		Assert.assertTrue(validator.isValid(null, context));
	}

	@Test
	public void testThatIsInvalidIfStringIsSmallerThanParameter() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("s1"));
		Assert.assertFalse(validator.isValid("as", context));
	}

	@Test
	public void testThatIsInvalidIfStringIsBiggerThanParameter() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("s2"));
		Assert.assertFalse(validator.isValid("12345678912", context));
	}

	@Test(expected = IllegalStateException.class)
	public void testThatThrowsExceptionIfMinIsBiggerThanMax() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("s4"));
	}

	@Test(expected = IllegalStateException.class)
	public void testThatThrowsExceptionIfMinIsNegative() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("s5"));
	}

	@Test
	public void testThatIsValidIfBetweenMaxAndMin() {
		StellaLengthValidator validator = new StellaLengthValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Length.class).atField("s3"));
		Assert.assertTrue(validator.isValid("1234567890", context));
	}

	public static class AnnotatedModel {
		@Length
		public String foo = null;
		@Length
		public Integer bar = null;
		@Length(min = 10)
		public String s1;
		@Length(max = 10)
		public String s2;
		@Length(min = 10, max = 10)
		public String s3;
		@Length(min = 11, max = 10)
		public String s4;
		@Length(min = -1, max = 10)
		public String s5;
	}
}
