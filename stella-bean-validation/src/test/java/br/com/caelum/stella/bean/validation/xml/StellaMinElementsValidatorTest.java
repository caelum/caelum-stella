package br.com.caelum.stella.bean.validation.xml;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.ConstraintValidatorContext;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.xml.MinElements;
import br.com.caelum.stella.bean.validation.xml.logic.StellaMinElementsValidator;

@SuppressWarnings("deprecation")
public class StellaMinElementsValidatorTest {
	
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

    @Test
    public void testThatNullIsValid() {
		StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        Assert.assertTrue(validator.isValid(null,context));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfAnnotatedElementIsNotACollectionOrArray() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.isValid("",context);
    }

    @Test
    public void testThatDoesNotThrowExceptionIfAnnotatedElementIsACollection() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        validator.isValid(new ArrayList<String>(),context);
    }

    @Test
    public void testThatDoesNotThrowsExceptionIfAnnotatedElementIsAnArray() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        validator.isValid(new Integer[10],context);
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsBiggerThanCollectionSize() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        Assert.assertFalse(validator.isValid(list,context));
    }

    @Test
    public void testThatIsValidIfElementNumberIsSmallerThanCollectionSize() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        Assert.assertTrue(validator.isValid(list,context));
    }

    @Test
    public void testThatIsValidIfElementNumberIsSmallerThanNonNullArrayElements() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        Integer[] array = new Integer[100];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        Assert.assertTrue(validator.isValid(array,context));
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsSmallerThanNonNullArrayElements() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        Assert.assertFalse(validator.isValid(new Integer[100],context));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfObjectIsArrayOfPrimitiveTypes() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        validator.isValid(new int[10],context);
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfValueIsNegative() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(new Mirror().on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c2"));
    }

    public static class AnnotatedModel {
        @MinElements(2)
        public Collection<String> c;

        @MinElements(-2)
        public Collection<String> c2;

    }
}
