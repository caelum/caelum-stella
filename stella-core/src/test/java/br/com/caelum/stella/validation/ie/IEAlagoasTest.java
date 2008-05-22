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

public class IEAlagoasTest {

    /*
     * FORMAÇÃO: 24XNNNNND, sendo:
     * 
     * 24 – Código do Estado
     * 
     * X – Tipo de empresa (0-Normal, 3-Produtor Rural,5-Substituta, 7-
     * Micro-Empresa Ambulante, 8-Micro-Empresa)
     * 
     * NNNNN – Número da empresa
     * 
     * D – Dígito de verificação calculado pelo Módulo11,pêsos 2 à 9 da direita
     * para a esquerda, exceto D
     * 
     * Exemplo: 2 4 0 0 0 0 0 4 8
     */

    private static final String wrongCheckDigitUnformattedString = "240000040";
    private static final String validUnformattedString = "240000048";
    private static final String validFormattedString = "24.000.004-8";

    private Validator<String> newValidator() {
        return new IEAlagoasValidator();
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
        Validator validator = new IEAlagoasValidator(messageProducer, false);
        try {
            validator
                    .assertValid(validUnformattedString.replaceFirst(".", "&"));
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
        Validator validator = new IEAlagoasValidator(messageProducer, false);
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
        Validator validator = new IEAlagoasValidator(messageProducer, false);

        String value = validUnformattedString + "0";
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
    public void shouldNotValidateIEWithNineDigitsAndCheckDigitsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new IEAlagoasValidator(messageProducer, false);

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
        Validator validator = new IEAlagoasValidator(messageProducer, false);

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
    public void shouldValidateMultipleValidIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEAlagoasValidator(messageProducer, true);

        List<ValidationMessage> errors;

        String[] validValues = { "24.076.739-0", "24.103.644-5",
                "24.089.826-5", "24.099.991-6", "24.067.173-2", "24.102.358-0",
                "24.079.990-9", "24.089.451-0", "24.080.152-0", "24.092.497-5",
                "24.095.056-9", "24.099.899-5", "24.104.510-0", "24.069.666-2",
                "24.088.932-0", "24.097.262-7", "24.086.162-0", "24.097.871-4",
                "24.085.016-5", "24.073.874-8", "24.071.760-0", "24.065.706-3",
                "24.054.337-8", "24.102.324-6", "24.105.106-1", "24.104.536-3",
                "24.086.313-5", "24.089.826-5" };
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
        Validator validator = new IEAlagoasValidator(messageProducer, false);

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
        Validator validator = new IEAlagoasValidator(messageProducer, true);
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
        Validator validator = new IEAlagoasValidator(messageProducer, true);

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
