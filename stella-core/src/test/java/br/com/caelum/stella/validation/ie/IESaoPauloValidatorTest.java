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

public class IESaoPauloValidatorTest {
    
    private final String validString = "P-01100424.3/002";
    private final String wrongCheckDigitString = "P-01100424.0/002";
    
    private Validator<String> newValidator(){
        return new IESaoPauloValidator();
    }
    
    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted(){
        newValidator().assertValid(validString);
        
        try {
            newValidator().assertValid(wrongCheckDigitString);
        } catch (RuntimeException e) {
            if (e instanceof InvalidStateException) {
                InvalidStateException invalidStateException = (InvalidStateException) e;
                String expected = "IEError : INVALID CHECK DIGITS";
                assertEquals(expected, invalidStateException.getInvalidMessages().get(0).getMessage());
            } else {
                fail();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidIERural() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IESaoPauloValidator(
                messageProducer, false);

        List<ValidationMessage> errors;
        // VALID IE = P-01100424.3/002
        String value = "P011004243002";
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
    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateValidIERuralWithWrongFormat() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new IESaoPauloValidator(
                messageProducer, false);

        // VALID IE = P-01100424.3/002
        try {
            String value = "L011004243002";
            validator.assertValid(value);
            fail();
        } catch (RuntimeException e) {
           throw e;
        } finally {
            mockery.assertIsSatisfied();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidIEParaComercioIndustria() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IESaoPauloValidator(
                messageProducer, false);

        List<ValidationMessage> errors;

        String value = "110042490114";
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
    public void shouldValidateValidFormattedIERural() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations());
        Validator validator = new IESaoPauloValidator(
                messageProducer, true);
        List<ValidationMessage> errors;

        // VALID IE = P-01100424.3/002
        String value = "P-01100424.3/002";
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
    public void shouldValidateValidFormattedIEParaComercioIndustria() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations());
        Validator validator = new IESaoPauloValidator(
                messageProducer, true);
        List<ValidationMessage> errors;

        // VALID IE = 110.042.490.114
        String value = "110.042.490.114";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

}
