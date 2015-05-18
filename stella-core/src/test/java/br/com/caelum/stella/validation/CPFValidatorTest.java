package br.com.caelum.stella.validation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class CPFValidatorTest {

	private static final String INVALID_FORMAT = "INVALID FORMAT";

	private static final String REPEATED_DIGITS = "REPEATED DIGITS";

	private static final String INVALID_CHECK_DIGITS = "INVALID CHECK DIGITS";

	private static final String INVALID_DIGITS = "INVALID DIGITS";
	
    private final String validString = "248.438.034-80";
    private final String validStringNotFormatted = "24843803480";

    private final String firstCheckDigitWrongNotFormatted = "24843803470";

	private CPFValidator validator;

	@Before
	public void setUp() {
		validator = new CPFValidator();
	}
    
    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsNotFormatted() {
        new CPFValidator().assertValid(validStringNotFormatted);

        try {
            new CPFValidator().assertValid(firstCheckDigitWrongNotFormatted);
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
    public void shouldNotValidateCPFWithInvalidCharacter() {
        try {
            validator.assertValid("1111111a111");
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCPFWithLessDigitsThanAllowed() {
        try {
            validator.assertValid("1234567890");
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCPFWithMoreDigitsThanAlowed() {
        try {
        	String value = "123456789012";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCPFCheckDigitsWithFirstCheckDigitWrong() {
        // VALID CPF = 248.438.034-80
        try {
        	String value = "24843803470";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_CHECK_DIGITS);
        }
    }

    @Test
    public void shouldNotValidateCPFCheckDigitsWithSecondCheckDigitWrong() {
        // VALID CPF = 099.075.865-60
        try {
        	String value = "09907586561";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_CHECK_DIGITS);
        }
    }
    
    @Test
    public void shouldNeverThrowsNPE() {
		assertThat(validator.isEligible(null), is(false));
	}

    @Test
    public void shouldValidateValidCPF() {
        validator.assertValid("11144477735");
        validator.assertValid("88641577947");
        validator.assertValid("34608514300");
        validator.assertValid("47393545608");
    }

    @Test
    public void shouldValidateNullCPF() {
        String value = null;
        validator.assertValid(value);
    }

    @Test
    public void shouldValidateCPFWithLeadingZeros() {
        String value = "01169538452";
        validator.assertValid(value);
    }

    @Test
    public void shouldNotValidateCPFWithAllRepeatedDigitsWhenNotIgnoringIt() {
        CPFValidator validator = new CPFValidator(false, false);
        try {
        	String value = "44444444444";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, REPEATED_DIGITS);
        }
    }
    
    @Test
    public void shouldNotValidateCPFWithAllRepeatedDigitsByDefault() {
        try {
        	String value = "44444444444";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, REPEATED_DIGITS);
        }
    }
    
    @Test
    public void shouldValidateCPFWithAllRepeatedDigitsWhenIgnoringIt() {
        CPFValidator validator = new CPFValidator(false,true);
        String value = "44444444444";
        validator.assertValid(value);
    }

    @Test
    public void shouldValidateValidFormattedCPF() {
        CPFValidator validator = new CPFValidator(true);
        // VALID CPF = 356.296.825-63
        String value = "356.296.825-63";
        validator.assertValid(value);
    }

    @Test
    public void shouldNotValidateValidUnformattedCPF() {
        CPFValidator validator = new CPFValidator(true);
        // VALID CPF = 332.375.322-40
        try {
        	String value = "33237532240";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
            assertMessage(e, INVALID_FORMAT);
        }
    }

    @Test
    public void shouldBeEligibleDefaultConstructor() {
        final CPFValidator cpfValidator = new CPFValidator();
        assertTrue(cpfValidator.isEligible(validStringNotFormatted));
        assertFalse(cpfValidator.isEligible(validString));
    }

    @Test
    public void shouldBeEligibleConstructorNotFormatted() {
        final CPFValidator cpfValidator = new CPFValidator(false);
        assertTrue(cpfValidator.isEligible(validStringNotFormatted));
        assertFalse(cpfValidator.isEligible(validString));
    }

    @Test
    public void shouldBeEligibleConstructorFormatted() {
        final CPFValidator cpfValidator = new CPFValidator(true);
        assertFalse(cpfValidator.isEligible(validStringNotFormatted));
        assertTrue(cpfValidator.isEligible(validString));
    }

    @Test
    public void shouldGenerateValidFormattedCPF() {
        final CPFValidator cpfValidator = new CPFValidator(true);
        final String generated = cpfValidator.generateRandomValid();
        cpfValidator.assertValid(generated);
    }

    @Test
    public void shouldGenerateValidUnformattedCPF() {
        final CPFValidator cpfValidator = new CPFValidator();
        final String generated = cpfValidator.generateRandomValid();
        cpfValidator.assertValid(generated);
    }
}
