package br.com.caelum.stella.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class CNPJValidatorTest {

    private static final String INVALID_FORMAT = "INVALID FORMAT";

	private static final String INVALID_CHECK_DIGITS = "INVALID CHECK DIGITS";

	private static final String INVALID_DIGITS = "INVALID DIGITS";

	private final String validString = "26.637.142/0001-58";
	private final String validStringNotFormatted = "26637142000158";

    private final String firstCheckDigitWrongNotFormatted = "26637142000168";

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsNotFormatted() {

    	new CNPJValidator().assertValid(validStringNotFormatted);
        try {
            new CNPJValidator().assertValid(firstCheckDigitWrongNotFormatted);
            fail("Test expected to throw exception");
        } catch (InvalidStateException e) {
            InvalidStateException invalidStateException = (InvalidStateException) e;
            assertMessage(invalidStateException, INVALID_CHECK_DIGITS);
        }
    }

	private void assertMessage(InvalidStateException invalidStateException, String expected) {
		assertTrue(invalidStateException.getInvalidMessages().get(0).getMessage().contains(expected));
	}

    @Test
    public void shouldNotValidateCNPJWithLessDigitsThanAllowed() {
        CNPJValidator validator = new CNPJValidator();
        try {
            String value = "1234567890123";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }
    
    @Test
    public void shouldNotValidateCNPJWithMoreDigitsThanAllowed() {
        CNPJValidator validator = new CNPJValidator();
        try {
            String value = "123456789012345";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCNPJWithInvalidCharacter() {
        CNPJValidator validator = new CNPJValidator(false);
        try {
            String value = "1111111a111111";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldValidateValidCNPJ() {
        CNPJValidator validator = new CNPJValidator();

        validator.assertValid("11222333000181");
        validator.assertValid("63025530002409");
        validator.assertValid("61519128000150");
        validator.assertValid("68745386000102");
    }

    @Test
    public void shoulValidateNullCNPJ() {
        CNPJValidator validator = new CNPJValidator();
        String value = null;
        validator.assertValid(value);
    }

    @Test
    public void shouldNotValidateCNPJCheckDigitsWithFirstCheckDigitWrong() {
        CNPJValidator validator = new CNPJValidator();
        // VALID CNPJ = 742213250001-30
        try {
            String value = "74221325000160";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_CHECK_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCNPJCheckDigitsWithSecondCheckDigitWrong() {
        CNPJValidator validator = new CNPJValidator();

        // VALID CNPJ = 266371420001-58
        try {
            String value = "26637142000154";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_CHECK_DIGITS);
        }
    }

    @Test
    public void shouldValidateValidFormattedCNPJ() {
        CNPJValidator validator = new CNPJValidator(true);
        String value = validString;
        validator.assertValid(value);
    }

    @Test
    public void shouldNotValidateValidUnformattedCNPJWhenExplicity() {
        CNPJValidator validator = new CNPJValidator(true);

        // VALID CNPJ = 26.637.142/0001-58
        try {
            String value = "26637142000158";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size() == 1);
        	assertMessage(e, INVALID_FORMAT);
        }
    }

    @Test
    public void shouldNotBeEligibleWithNullCNPJ() {
        final CNPJValidator cnpjValidator = new CNPJValidator();
        assertFalse(cnpjValidator.isEligible(null));
    }
    
    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateFormattedCnpjWithAllRepeatedDigits() {
        CNPJValidator validator = new CNPJValidator(true);
        String cnpj = "00.000.000/0000-00";
        validator.assertValid(cnpj);
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateUnformattedCnpjWithAllRepeatedDigits() {
        CNPJValidator validator = new CNPJValidator();
        String cnpj = "00000000000000";
        validator.assertValid(cnpj);
    }

    @Test
    public void shouldValidateFormattedCnpjWithAllRepeatedDigits() {
        CNPJValidator validator = new CNPJValidator(true, true);
        String cnpj = "00.000.000/0000-00";
        validator.assertValid(cnpj);
    }

    @Test
    public void shouldValidateUnformattedCnpjWithAllRepeatedDigits() {
        CNPJValidator validator = new CNPJValidator(false, true);
        String cnpj = "00000000000000";
        validator.assertValid(cnpj);
    }
    
    @Test
    public void shouldBeEligibleDefaultConstructor() {
        final CNPJValidator cnpjValidator = new CNPJValidator();
        assertTrue(cnpjValidator.isEligible(validStringNotFormatted));
        assertFalse(cnpjValidator.isEligible(validString));
    }

    @Test
    public void shouldBeEligibleConstructorNotFormatted() {
        final CNPJValidator cnpjValidator = new CNPJValidator(false);
        assertTrue(cnpjValidator.isEligible(validStringNotFormatted));
        assertFalse(cnpjValidator.isEligible(validString));
    }

    @Test
    public void shouldBeEligibleConstructorFormatted() {
        final CNPJValidator cnpjValidator = new CNPJValidator(true);
        assertFalse(cnpjValidator.isEligible(validStringNotFormatted));
        assertTrue(cnpjValidator.isEligible(validString));
    }

    @Test
    public void shouldGenerateValidFormattedCNPJ() {
        final CNPJValidator cnpjValidator = new CNPJValidator(true);
        final String generated = cnpjValidator.generateRandomValid();
        cnpjValidator.assertValid(generated);
    }

    @Test
    public void shouldGenerateValidUnformattedCNPJ() {
        final CNPJValidator cnpjValidator = new CNPJValidator();
        final String generated = cnpjValidator.generateRandomValid();
        cnpjValidator.assertValid(generated);
    }
}
