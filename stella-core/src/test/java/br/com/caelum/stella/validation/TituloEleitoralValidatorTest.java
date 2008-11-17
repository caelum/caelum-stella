package br.com.caelum.stella.validation;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class TituloEleitoralValidatorTest {

    private final String[] validStrings = { "543275360116", "452083221724", "253346440540", "553505611201",
            "884328631058" };

    private final String[] invalidFirstDigitStrings = { "543275360106", "452083221714", "253346440520", "553505611231",
            "884328631048" };

    private final String[] invalidSecondDigitStrings = { "543275360119", "452083221728", "253346440547",
            "553505611206", "884328631055" };

    private Validator<String> validator;

    @Before
    public void setup() {
        validator = new TituloEleitoralValidator();
    }

    @Test
    public void shouldValidateCorrectString() {
        for (String validString : validStrings) {
            validator.assertValid(validString);
        }
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateStringWithFirstCheckDigitWrong() {
        for (String invalidString : invalidFirstDigitStrings) {
            validator.assertValid(invalidString);
        }
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateStringWithSecondCheckDigitWrong() {
        for (String invalidString : invalidSecondDigitStrings) {
            validator.assertValid(invalidString);
        }
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateStringMoreDigits() {
        validator.assertValid(validStrings[0] + "0");
    }

}
