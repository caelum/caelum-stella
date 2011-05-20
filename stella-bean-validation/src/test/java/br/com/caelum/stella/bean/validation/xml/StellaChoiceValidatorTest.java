package br.com.caelum.stella.bean.validation.xml;

import javax.validation.ConstraintValidatorContext;

import net.vidageek.mirror.dsl.Mirror;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.Choice;
import br.com.caelum.stella.bean.validation.xml.ChoiceItem;
import br.com.caelum.stella.bean.validation.xml.logic.StellaChoiceValidator;

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

	@Choice
	public static class AnnotatedModel3 {
		@ChoiceItem
		private final String bar = "a bar";
		@ChoiceItem
		private final Integer i = 0;
		private final String foo = "a foo";
	}
	
	@Test
	public void testThatMultipleChoiceWithMoreThanOneItenNotNullShoudNotPass() {
		StellaChoiceValidator validator = new StellaChoiceValidator();
		validator.initialize(new Mirror().on(AnnotatedModel3.class).reflect().annotation(Choice.class).atClass());
		Assert.assertFalse(validator.isValid(new AnnotatedModel3(), context));
	}
	
	@Choice
	public static class AnnotatedModel4 {
		@ChoiceItem
		private final String bar = null;
		@ChoiceItem
		private final Integer i = 0;
		private final String foo = "a foo";
	}
	
	@Test
	public void testThatMultipleChoiceWithOnlyOneItenNotNullShoudPass() {
		StellaChoiceValidator validator = new StellaChoiceValidator();
		validator.initialize(new Mirror().on(AnnotatedModel4.class).reflect().annotation(Choice.class).atClass());
		Assert.assertTrue(validator.isValid(new AnnotatedModel4(), context));
	}
	
	
	
}
