package br.com.caelum.stella.hibernate.validator.xml;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaPatternValidator;

public class StellaPatternValidatorTest {
	private ConstraintValidatorContext context = Mockito
			.mock(ConstraintValidatorContext.class);

	public static class AnnotatedModel {
		@Pattern("")
		public Integer i;
	}

	public static class AnnotatedModel2 {
		@Pattern("[ab]*c")
		public String i;
	}

	@Test
	public void testThatIsValidIfPatternMatchesWholeString() {
		StellaPatternValidator validator = new StellaPatternValidator();
		validator.initialize(new Mirror().on(AnnotatedModel2.class).reflect()
				.annotation(Pattern.class).atField("i"));
		Assert.assertEquals(true, validator.isValid("babac", context));
	}

	public static class AnnotatedModel3 {
		@Pattern("[ab]*")
		public String i;
	}

	@Test
	public void testThatIsNotValidIfMatchIsPartial() {
		StellaPatternValidator validator = new StellaPatternValidator();
		validator.initialize(new Mirror().on(AnnotatedModel3.class).reflect()
				.annotation(Pattern.class).atField("i"));
		Assert.assertEquals(false, validator.isValid("babac", context));
	}

	@Test
	public void testThatNullIsValid() {
		StellaPatternValidator validator = new StellaPatternValidator();
		validator.initialize(new Mirror().on(AnnotatedModel3.class).reflect()
				.annotation(Pattern.class).atField("i"));
		Assert.assertEquals(true, validator.isValid(null, context));
	}

}
