package br.com.caelum.stella.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

/**
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class CNPJValidatorTest {

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(2).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);
        List<ValidationMessage> errors;
        try {
        	validator.assertValid("1234567890123");
        	fail();
        } catch (InvalidStateException e) {
		}
        errors = validator.getValidationMessages("1234567890123");
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithMoreDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);
        List<ValidationMessage> errors;

        assertFalse(validator.assertValid("123456789012345"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);
        List<ValidationMessage> errors;

        assertFalse(validator.assertValid("1111111a111111"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations() {
            {

            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);

        List<ValidationMessage> errors;

        assertTrue(validator.assertValid("63025530002409"));
        errors = validator.getValidationMessages();
        assertTrue(errors.isEmpty());

        assertTrue(validator.assertValid("61519128000150"));
        errors = validator.getValidationMessages();
        assertTrue(errors.isEmpty());

        assertTrue(validator.assertValid("68745386000102"));
        errors = validator.getValidationMessages();
        assertTrue(errors.isEmpty());

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shoulValidateNullCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations() {
            {

            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);

        List<ValidationMessage> errors;
        assertTrue(validator.assertValid(null));
        errors = validator.getValidationMessages();
        assertTrue(errors.isEmpty());
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJCheckDigitsWithFirstCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);
        List<ValidationMessage> errors;

        // VALID CNPJ = 742213250001-30
        assertFalse(validator.assertValid("74221325000160"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJCheckDigitsWithSecondCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, false);
        List<ValidationMessage> errors;

        // VALID CNPJ = 266371420001-58
        assertFalse(validator.assertValid("26637142000154"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidFormattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {

            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, true);
        List<ValidationMessage> errors;

        // VALID CNPJ = 26.637.142/0001-58
        assertTrue(validator.assertValid("26.637.142/0001-58"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 0);

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldVotValidateValidUnformattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_FORMAT);
            }
        });
        AbstractValidator validator = new CNPJValidator(messageProducer, true);
        List<ValidationMessage> errors;

        // VALID CNPJ = 26.637.142/0001-58
        assertFalse(validator.assertValid("26637142000158"));
        errors = validator.getValidationMessages();
        assertTrue(errors.size() == 1);

        mockery.assertIsSatisfied();
    }

}
