package br.com.caelum.stella.hibernate.validator.xml;

import net.vidageek.mirror.Mirror;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaChoiceValidator;

@SuppressWarnings("unused")
public class StellaChoiceValidatorTest {

    @Choice
    public static class AnnotatedModel {
        private final String bar = null;
        private final Integer i = 0;
        private final String foo = null;
    }

    @Test
    public void testThatOneSettedElementIsOk() {
        StellaChoiceValidator validator = new StellaChoiceValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Choice.class).atClass());
        Assert.assertTrue(validator.isValid(new AnnotatedModel()));
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
        validator.initialize(Mirror.on(AnnotatedModel2.class).reflect().annotation(Choice.class).atClass());
        Assert.assertTrue(validator.isValid(new AnnotatedModel2()));
    }
}
