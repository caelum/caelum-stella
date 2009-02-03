package br.com.caelum.stella.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.RenavamError;

public class RenavamValidationTest {

    private final String validUnformattedRenavam1 = "639884962";
    private final String validUnformattedRenavam2 = "811443620";
    private final String validFormattedRenavam1 = "73.640767-7";
    private final String validFormattedRenavam2 = "96.525195-0";
    private final String renavamUnformattedWithInvalidCheckDigit = "639884969";
    private final String renavamFormattedWithInvalidCheckDigit = "96.525195-2";
    private final String renavamWithLessThenNineDigits = "999999";
    private final String renavamWithMoreThenNineDigits = "9999999999";

    @Test
    public void shouldValidateValidUnformatedRenavam() {
        RenavamValidator validator = new RenavamValidator(false);
        validator.assertValid(validUnformattedRenavam1);
        validator.assertValid(validUnformattedRenavam2);

        List<ValidationMessage> errorMessages = validator.invalidMessagesFor(validUnformattedRenavam1);
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    public void shouldValidateFormattedValidRenavam() {
        RenavamValidator validator = new RenavamValidator();
        validator.assertValid(validFormattedRenavam1);
        validator.assertValid(validFormattedRenavam2);

        List<ValidationMessage> errorMessages = validator.invalidMessagesFor(validFormattedRenavam1);
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    public void shouldConsiderAValidFormattedRenavamAsEligible() {
        RenavamValidator validator = new RenavamValidator();
        assertTrue(validator.isEligible(validFormattedRenavam1));
        assertTrue(validator.isEligible(validFormattedRenavam2));
        assertTrue(validator.isEligible(renavamFormattedWithInvalidCheckDigit));
    }

    @Test
    public void shouldConsiderAValidUnformattedRenavamAsEligible() {
        RenavamValidator validator = new RenavamValidator(false);
        assertTrue("Renamvam " + validUnformattedRenavam1 + " must be eligible.", validator
                .isEligible(validUnformattedRenavam1));
        assertTrue(validator.isEligible(validUnformattedRenavam2));
        assertTrue(validator.isEligible(renavamUnformattedWithInvalidCheckDigit));
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidadeUnformattedRenavamWithInvalidCheckDigit() {
        RenavamValidator validator = new RenavamValidator(false);
        validator.assertValid(renavamUnformattedWithInvalidCheckDigit);
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidadeFormattedRenavamWithInvalidCheckDigit() {
        RenavamValidator validator = new RenavamValidator();
        validator.assertValid(renavamFormattedWithInvalidCheckDigit);
    }

    @Test
    public void onlyRenavamWithNineDigitsAreEligible() {
        RenavamValidator validator = new RenavamValidator();
        assertFalse(validator.isEligible(renavamWithLessThenNineDigits));
        assertFalse(validator.isEligible(renavamWithMoreThenNineDigits));
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateARenavamWithLessThenNineDigits() {
        RenavamValidator validator = new RenavamValidator();
        validator.assertValid(renavamWithLessThenNineDigits);
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateARenavamWithMoreThenNineDigits() {
        RenavamValidator validator = new RenavamValidator();
        validator.assertValid(renavamWithMoreThenNineDigits);
    }

    @Test
    public void renavamMustHaveOnlyNumbers() {
        RenavamValidator validator = new RenavamValidator();
        assertFalse(validator.isEligible("99999999x"));
        assertFalse(validator.isEligible("9999999 9"));
    }

    @Test
    public void shouldGenerateExplanatoryErrorMessagesForUnformattedRenavam() {
        RenavamValidator validator = new RenavamValidator(false);
        List<ValidationMessage> invalidMessagesFor = null;

        invalidMessagesFor = validator.invalidMessagesFor("999");
        assertTrue(invalidMessagesFor.size() == 1);
        assertEquals("RenavamError : INVALID DIGITS", invalidMessagesFor.get(0).getMessage());

        invalidMessagesFor = validator.invalidMessagesFor(renavamUnformattedWithInvalidCheckDigit);
        assertTrue(invalidMessagesFor.size() == 1);
        assertEquals("RenavamError : INVALID CHECK DIGIT", invalidMessagesFor.get(0).getMessage());
    }

    @Test
    public void shouldGenerateExplanatoryErrorMessagesForFormattedRenavam() {
        RenavamValidator validator = new RenavamValidator();
        List<ValidationMessage> invalidMessagesFor = null;

        invalidMessagesFor = validator.invalidMessagesFor("999");
        assertTrue(invalidMessagesFor.size() == 1);
        assertEquals("RenavamError : INVALID DIGITS", invalidMessagesFor.get(0).getMessage());

        invalidMessagesFor = validator.invalidMessagesFor(renavamFormattedWithInvalidCheckDigit);
        assertTrue(invalidMessagesFor.size() == 1);
        assertEquals("RenavamError : INVALID CHECK DIGIT", invalidMessagesFor.get(0).getMessage());
    }

    @Test
    public void shouldUseAnSimpleMessageProducerAsDefault() {
        RenavamValidator validator = new RenavamValidator();
        try {
            validator.assertValid(renavamFormattedWithInvalidCheckDigit);
            fail();
        } catch (InvalidStateException e) {
            List<ValidationMessage> errors = e.getInvalidMessages();
            assertTrue(errors.size() == 1);
            assertEquals("RenavamError : INVALID CHECK DIGIT", errors.get(0).getMessage());
        }
    }

    @Test
    public void shouldUseTheMessageProducerPassedForTheConstructorAsAnArgument() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(RenavamError.INVALID_CHECK_DIGIT);
            }
        });

        RenavamValidator validator = new RenavamValidator(messageProducer, true);
        try {
            validator.assertValid(renavamFormattedWithInvalidCheckDigit);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }
}
