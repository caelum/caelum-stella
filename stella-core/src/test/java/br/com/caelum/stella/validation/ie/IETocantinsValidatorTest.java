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

public class IETocantinsValidatorTest {

    /*
     * Formato: 8 dígitos (empresa)+1 dígito verificador
     * 
     * Exemplo valido: 29.040.636-6 29.040.634-0 29.385.524-2 29.032.038-0
     * 
     * Exemplo antigo valido : 29010227836
     */

    private static final String wrongCheckDigitUnformattedNovaString = "290406360";
    private static final String validUnformattedNovaString = "290406366";
    private static final String validFormattedNovaString = "29.040.636-6";
    private static final String[] validValues = { validFormattedNovaString};

    private static final String wrongCheckDigitUnformattedAntigaString = "29010227838";
    private static final String validUnformattedAntigaString = "29010227836";
    private static final String validFormattedAntigaString = "29.01.022.783-6";
    
    
    private Validator<String> newValidator() {
        return new IETocantinsValidator();
    }

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
        newValidator().assertValid(validFormattedNovaString);

        try {
            newValidator().assertValid(validFormattedNovaString);
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
        Validator validator = new IETocantinsValidator(messageProducer, false);
        try {
            validator
                    .assertValid(validUnformattedNovaString.replaceFirst(".", "&"));
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
        Validator validator = new IETocantinsValidator(messageProducer, false);
        try {
            validator.assertValid(validUnformattedNovaString.replaceFirst(".", ""));
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
        Validator validator = new IETocantinsValidator(messageProducer, false);

        String value = validUnformattedNovaString + "5";
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
    public void shouldNotValidateIEsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new IETocantinsValidator(messageProducer, false);

        String value = wrongCheckDigitUnformattedNovaString;
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
        Validator validator = new IETocantinsValidator(messageProducer, true);

        List<ValidationMessage> errors;

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
    public void shouldValidateValidFormattedNovaIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IETocantinsValidator(messageProducer, true);

        List<ValidationMessage> errors;

        String[] validValues = { validFormattedNovaString };
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
    public void shouldValidateValidFormattedAntigaIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IETocantinsValidator(messageProducer, true);

        List<ValidationMessage> errors;

        String[] validValues = { validFormattedAntigaString };
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
        Validator validator = new IETocantinsValidator(messageProducer, false);

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
        Validator validator = new IETocantinsValidator(messageProducer, true);

        String value = validFormattedNovaString.replace('.', ':');
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

}
