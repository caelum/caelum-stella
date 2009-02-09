package br.com.caelum.stella.hibernate.validator.xml;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.Test;

import br.com.caelum.stella.hibernate.validator.xml.logic.StellaPatternValidator;

public class StellaPatternValidatorTest {

    public static class AnnotatedModel {
        @Pattern("")
        public Integer i;
    }

    @Test(expected = IllegalStateException.class)
    public void testThatThrowsExceptionIfFieldIsNotAString() {
        StellaPatternValidator validator = new StellaPatternValidator();
        validator.initialize(Mirror.on(AnnotatedModel.class).reflect().annotation(Pattern.class).atField("i"));
        validator.isValid(new Integer(2));
    }

    public static class AnnotatedModel2 {
        @Pattern("[ab]*c")
        public String i;
    }

    @Test
    public void testThatIsValidIfPatternMatchesWholeString() {
        StellaPatternValidator validator = new StellaPatternValidator();
        validator.initialize(Mirror.on(AnnotatedModel2.class).reflect().annotation(Pattern.class).atField("i"));
        Assert.assertEquals(true, validator.isValid("babac"));
    }

    public static class AnnotatedModel3 {
        @Pattern("[ab]*")
        public String i;
    }

    @Test
    public void testThatIsNotValidIfMatchIsPartial() {
        StellaPatternValidator validator = new StellaPatternValidator();
        validator.initialize(Mirror.on(AnnotatedModel3.class).reflect().annotation(Pattern.class).atField("i"));
        Assert.assertEquals(false, validator.isValid("babac"));
    }

    @Test
    public void testThatNullIsValid() {
        StellaPatternValidator validator = new StellaPatternValidator();
        validator.initialize(Mirror.on(AnnotatedModel3.class).reflect().annotation(Pattern.class).atField("i"));
        Assert.assertEquals(true, validator.isValid(null));
    }

}
