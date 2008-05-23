package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEPiauiValidatorTest {

    /*
     * Formato: 8 dígitos (empresa)+1 dígito verificador Exemplo: 19.301.656-7
     */

    private static final String wrongCheckDigitUnformattedString = "193016560";
    private static final String validUnformattedString = "193016567";
    private static final String validFormattedString = "19.301.656-7";

    private Validator<String> newValidator() {
        return new IEPiauiValidator();
    }

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
        newValidator().assertValid(validFormattedString);

        try {
            newValidator().assertValid(validFormattedString);
        } catch (RuntimeException e) {
            if (e instanceof InvalidStateException) {
                InvalidStateException invalidStateException = (InvalidStateException) e;
                String expected = "IEError : INVALID CHECK DIGITS";
                assertEquals(expected, invalidStateException
                        .getInvalidMessages().get(0).getMessage());
            } else {
                fail();
            }
        }
    }

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
        Validator validator = new IEPiauiValidator(messageProducer, false);
        try {
            validator.assertValid(validUnformattedString.replaceFirst(".", "&"));
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
        Validator validator = new IEPiauiValidator(messageProducer, false);
        try {
            validator.assertValid(validUnformattedString.replaceFirst(".", ""));
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
        Validator validator = new IEPiauiValidator(messageProducer, false);

        String value = validUnformattedString + "5";
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
    public void shouldNotValidateIECheckDigitsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new IEPiauiValidator(messageProducer, false);

        String value = wrongCheckDigitUnformattedString;
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
        Validator validator = new IEPiauiValidator(messageProducer, false);

        List<ValidationMessage> errors;

        String validValue = validUnformattedString;
        try {
            validator.assertValid(validValue);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(validValue);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateNullIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEPiauiValidator(messageProducer, false);

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
        Validator validator = new IEPiauiValidator(messageProducer, true);
        List<ValidationMessage> errors;

        String value = validFormattedString;
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
        Validator validator = new IEPiauiValidator(messageProducer, true);

        String value = validFormattedString.replace('.', ':');
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

}
