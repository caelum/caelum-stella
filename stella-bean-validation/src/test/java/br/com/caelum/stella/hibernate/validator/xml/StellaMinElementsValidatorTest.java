package br.com.caelum.stella.hibernate.validator.xml;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaMinElementsValidator;

public class StellaMinElementsValidatorTest {

    @Test
    public void testThatNullIsValid() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        Assert.assertTrue(validator.isValid(null));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfAnnotatedElementIsNotACollectionOrArray() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.isValid("");
    }

    @Test
    public void testThatDoesNotThrowExceptionIfAnnotatedElementIsACollection() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        validator.isValid(new ArrayList<String>());
    }

    @Test
    public void testThatDoesNotThrowsExceptionIfAnnotatedElementIsAnArray() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        validator.isValid(new Integer[10]);
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsBiggerThanCollectionSize() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        Assert.assertFalse(validator.isValid(list));
    }

    @Test
    public void testThatIsValidIfElementNumberIsSmallerThanCollectionSize() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        Assert.assertTrue(validator.isValid(list));
    }

    @Test
    public void testThatIsValidIfElementNumberIsSmallerThanNonNullArrayElements() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        Integer[] array = new Integer[100];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        Assert.assertTrue(validator.isValid(array));
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsSmallerThanNonNullArrayElements() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        Assert.assertFalse(validator.isValid(new Integer[100]));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfObjectIsArrayOfPrimitiveTypes() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c"));

        validator.isValid(new int[10]);
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfValueIsNegative() {
        StellaMinElementsValidator validator = new StellaMinElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MinElements.class).atField("c2"));
    }

    public static class AnnotatedModel {
        @MinElements(2)
        public Collection<String> c;

        @MinElements(-2)
        public Collection<String> c2;

    }
}
