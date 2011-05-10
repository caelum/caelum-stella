package br.com.caelum.stella.hibernate.validator.xml;

import javax.validation.ConstraintValidatorContext;

import net.vidageek.mirror.dsl.Mirror;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaChoiceValidator;

@SuppressWarnings("unused")
public class StellaChoiceValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

	@Choice
	public static class AnnotatedModel {
		private final String bar = null;
		private final Integer i = 0;
		private final String foo = null;
	}

	@Test
	public void testThatOneSettedElementIsOk() {
		StellaChoiceValidator validator = new StellaChoiceValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(Choice.class).atClass());
		Assert.assertTrue(validator.isValid(new AnnotatedModel(), context));
	}

	@Choice
	public static class AnnotatedModel2 {
		@ChoiceItem
		private final String bar = null;
		@ChoiceItem
		private final Integer i = 0;
		private final String foo = null;
	}

	@Test
	public void testThatMultipleChoiceItensSettedIsOk() {
		StellaChoiceValidator validator = new StellaChoiceValidator();
		validator.initialize(new Mirror().on(AnnotatedModel2.class).reflect().annotation(Choice.class).atClass());
		Assert.assertTrue(validator.isValid(new AnnotatedModel2(), context));
	}
}
