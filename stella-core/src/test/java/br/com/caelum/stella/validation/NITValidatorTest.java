package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class NITValidatorTest {

	private static final String INVALID_FORMAT = "INVALID FORMAT";
	private static final String INVALID_DIGITS = "INVALID DIGITS";
	private static final String INVALID_CHECK_DIGITS = "INVALID CHECK DIGITS";
	
    @Test
    public void shouldNotValidateNITWithInvalidCharacter() {
        NITValidator validator = new NITValidator();
        String value = "1111111a111";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    private void assertMessage(InvalidStateException invalidStateException, String expected) {
    	assertTrue(invalidStateException.getInvalidMessages().get(0).getMessage().contains(expected));
	}

	@Test
    public void shouldNotValidateNITWithLessDigitsThanAllowed() {
        NITValidator validator = new NITValidator();
        String value = "1234567890";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateNITWithMoreDigitsThanAlowed() {
        NITValidator validator = new NITValidator();
        String value = "123456789012";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateNITCheckDigitsWithCheckDigitWrong() {
        NITValidator validator = new NITValidator();
        // VALID NIT = 24.84380.348-0
        String value = "24843803470";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_CHECK_DIGITS);
        }
    }

    @Test
    public void shouldValidateValidNIT() {
		NITValidator validator = new NITValidator();

		validator.assertValid("12345678919");
		validator.assertValid("34608514300");
		validator.assertValid("47393545608");
    }

    @Test
    public void shouldValidateNullNIT() {
        NITValidator validator = new NITValidator();
        String value = null;
        validator.assertValid(value);
    }

    @Test
    public void shouldValidateValidFormattedNIT() {
        NITValidator validator = new NITValidator(true);
        // VALID NIT = 123.45678.91-9
        String value = "123.45678.91-9";
        validator.assertValid(value);
    }

    @Test
    public void shouldNotValidateValidUnformattedNIT() {
        NITValidator validator = new NITValidator(true);
        // VALID NIT = 12.34567.891-9
        String value = "12345678919";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_FORMAT);
        }
    }

    @Test
    public void shouldGenerateRandomValidUnformattedNIT() {
        NITValidator validator = new NITValidator(false);
        String value = validator.generateRandomValid();
        validator.assertValid(value);
    }

    @Test
    public void shouldGenerateRandomValidFormattedNIT() {
        NITValidator validator = new NITValidator(true);
        String value = validator.generateRandomValid();
        validator.assertValid(value);
    }
}
