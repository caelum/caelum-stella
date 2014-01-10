package br.com.caelum.stella.validation;

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

    private final String firstCheckDigitWrong = "26.637.142/0001-68";

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {

    	new CNPJValidator().assertValid(validString);
        try {
            new CNPJValidator().assertValid(firstCheckDigitWrong);
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
        CNPJValidator validator = new CNPJValidator();
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

}
