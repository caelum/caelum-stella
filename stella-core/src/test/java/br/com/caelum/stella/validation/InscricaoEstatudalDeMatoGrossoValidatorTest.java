package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.IEError;

public class InscricaoEstatudalDeMatoGrossoValidatorTest {

    /*
     * IE validas 13.193.686-7 13.053.551-6 13.056.071-5 13.076.269-5
     * 13.015.257-9 13.125.061-2 13.146.383-7 13.151.173-4 13.198.869-7
     * 13.198.868-9 13.191.575-4 13.178.718-7 13.191.879-6 13.197.541-2
     * 13.197.542-0 13.197.556-0 13.198.333-4 13.198.870-0 13.198.872-7
     * 13.205.160-5 13.199.075-6 13.199.463-8 13.198.871-9 13.199.464-6
     * 13.210.743-0 13.211.337-6 13.210.747-3 13.236.559-6 13.236.558-8
     * 13.241.890-8 13.246.644-9 13.256.554-4 13.284.135-5 13.286.376-6
     * 13.286.372-3
     */

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);
        try {
            validator.assertValid("132-02758");
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);
        try {
            validator.assertValid("32002758");
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);

        String value = "0132002758";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithCheckDigitsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);

        // VALID IE = ???
        String value = "132002758";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);

        List<ValidationMessage> errors;

        String[] validValues = { "131936867", "131936867", "130535516",
                "130560715", "130762695", "130152579", "131250612",
                "131463837", "131511734", "131988697", "131988689",
                "131915754", "131787187", "131918796", "131975412",
                "131975420", "131975560", "131983334", "131988700",
                "131988727", "132051605", "131990756", "131994638",
                "131988719", "131994646", "132107430", "132113376",
                "132107473", "132365596", "132365588", "132418908",
                "132466449", "132565544", "132841355", "132863766", "132863723" };
        for (String validValue : validValues) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateNullIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, false);

        List<ValidationMessage> errors;
        String value = null;
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidFormattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations());
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, true);
        List<ValidationMessage> errors;

        // VALID IE = 13.193.686-7
        String value = "13.193.686-7";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateValidUnformattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_FORMAT);
            }
        });
        Validator validator = new InscricaoEstatudalDeMatoGrossoValidator(
                messageProducer, true);

        // VALID IE = 13.193.686-7
        String value = "13+193.686-7";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

}
