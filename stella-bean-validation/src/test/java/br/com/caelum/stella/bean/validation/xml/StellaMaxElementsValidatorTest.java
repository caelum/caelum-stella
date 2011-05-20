package br.com.caelum.stella.bean.validation.xml;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.MaxElements;
import br.com.caelum.stella.bean.validation.xml.logic.StellaMaxElementsValidator;

@SuppressWarnings("deprecation")
public class StellaMaxElementsValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

	@Test
	public void testThatNullIsValid() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
		Assert.assertTrue(validator.isValid(null, context));
	}

	@Test(expected = IllegalStateException.class)
	public void testThatThrowsExceptionIfAnnotatedElementIsNotACollectionOrArray() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator.isValid("", context);
	}

	@Test
	public void testThatDoesNotThrowExceptionIfAnnotatedElementIsACollection() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
		validator.isValid(new ArrayList<String>(), context);
	}

	@Test
	public void testThatDoesNotThrowsExceptionIfAnnotatedElementIsAnArray() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
		validator.isValid(new Integer[10], context);
	}

	@Test
	public void testThatIsInvalidIfElementNumberIsSmallerThanCollectionSize() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		list.add("");
		list.add("");
		list.add("");
		Assert.assertFalse(validator.isValid(list, context));
	}

	@Test
	public void testThatIsValidIfElementNumberIsBiggerThanCollectionSize() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		list.add("");
		Assert.assertTrue(validator.isValid(list, context));
	}

	@Test
	public void testThatIsValidIfElementNumberIsBiggerThanNonNullArrayElements() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

		Assert.assertTrue(validator.isValid(new Integer[100], context));
	}

	@Test
	public void testThatIsInvalidIfElementNumberIsSmallerThanNonNullArrayElements() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

		Integer[] array = new Integer[100];
		array[0] = 1;
		array[1] = 1;
		array[2] = 1;
		Assert.assertFalse(validator.isValid(array, context));
	}

	@Test(expected = IllegalStateException.class)
	public void testThatThrowsExceptionIfObjectIsArrayOfPrimitiveTypes() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator
				.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

		validator.isValid(new int[10], context);
	}

	@Test(expected = IllegalStateException.class)
	public void testThatThrowsExceptionIfValueIsNegative() {
		StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
		validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MaxElements.class)
				.atField("c2"));
	}

	public static class AnnotatedModel {
		@MaxElements(2)
		public Collection<String> c;

		@MaxElements(-2)
		public Collection<String> c2;

	}
}
