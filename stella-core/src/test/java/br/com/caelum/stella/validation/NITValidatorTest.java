package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.NITError;

/**
 * @author Leonardo Bessa
 */
public class NITValidatorTest {

    @Test
    public void shouldNotValidateNITWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, false);

        String value = "1111111a111";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateNITWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, false);

        String value = "1234567890";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateNITWithMoreDigitsThanAlowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, false);

        String value = "123456789012";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateNITWithCheckDigitsWithFirstCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_CHECK_DIGITS);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, false);

        // VALID NIT = 24.84380.348-0
        String value = "24843803470";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateNITWithCheckDigitsWithSecondCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_CHECK_DIGITS);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, false);

        // VALID NIT = 099.075.865-60
        String value = "09907586561";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldValidateValidNIT() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        NITValidator validator = new NITValidator(messageProducer, false);

        List<ValidationMessage> errors;

        String value = "12345678919";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        value = "34608514300";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        value = "47393545608";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldValidateNullNIT() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        NITValidator validator = new NITValidator(messageProducer, false);

        String value = null;
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        List<ValidationMessage> errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldValidateValidFormattedNIT() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations());
        NITValidator validator = new NITValidator(messageProducer, true);

        // VALID NIT = 123.45678.91-9
        String value = "123.45678.91-9";
        try {
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        List<ValidationMessage> errors = validator.invalidMessagesFor(value);
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateValidUnformattedNIT() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(NITError.INVALID_FORMAT);
            }
        });
        NITValidator validator = new NITValidator(messageProducer, true);

        // VALID NIT = 12.34567.891-9
        String value = "12.34a67.891-9";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

}
