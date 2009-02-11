package br.com.caelum.stella.hibernate.validator.xml;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaMaxElementsValidator;

public class StellaMaxElementsValidatorTest {

    @Test
    public void testThatNullIsValid() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
        Assert.assertTrue(validator.isValid(null));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfAnnotatedElementIsNotACollectionOrArray() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.isValid("");
    }

    @Test
    public void testThatDoesNotThrowExceptionIfAnnotatedElementIsACollection() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
        validator.isValid(new ArrayList<String>());
    }

    @Test
    public void testThatDoesNotThrowsExceptionIfAnnotatedElementIsAnArray() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
        validator.isValid(new Integer[10]);
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsSmallerThanCollectionSize() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        Assert.assertFalse(validator.isValid(list));
    }

    @Test
    public void testThatIsValidIfElementNumberIsBiggerThanCollectionSize() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        Assert.assertTrue(validator.isValid(list));
    }

    @Test
    public void testThatIsValidIfElementNumberIsBiggerThanNonNullArrayElements() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

        Assert.assertTrue(validator.isValid(new Integer[100]));
    }

    @Test
    public void testThatIsInvalidIfElementNumberIsSmallerThanNonNullArrayElements() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

        Integer[] array = new Integer[100];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        Assert.assertFalse(validator.isValid(array));
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfObjectIsArrayOfPrimitiveTypes() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c"));

        validator.isValid(new int[10]);
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfValueIsNegative() {
        StellaMaxElementsValidator validator = new StellaMaxElementsValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(MaxElements.class).atField("c2"));
    }

    public static class AnnotatedModel {
        @MaxElements(2)
        public Collection<String> c;

        @MaxElements(-2)
        public Collection<String> c2;

    }
}
