package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IERioGrandeDoNorteValidatorTest extends IEValidatorTest {

	public IERioGrandeDoNorteValidatorTest() {
		super(wrongCheckDigitUnformattedStringWithTenDigits, validUnformattedStringWithNineDigits,
				validFormattedStringWithTenDigits, validValues);
	}

	private static final String wrongCheckDigitUnformattedStringWithTenDigits = "2000400403";

	private static final String validUnformattedStringWithNineDigits = "200400401";

	private static final String validUnformattedStringWithTenDigits = "2000400400";

	private static final String validFormattedStringWithNineDigits = "20.040.040-1";

	private static final String validFormattedStringWithTenDigits = "20.0.040.040-0";

	private static final String[] validValues = { validFormattedStringWithTenDigits, validFormattedStringWithNineDigits,
		"20.3.615.641-0", "20.5.276.231-0", "20.3.756.176-8", "20.3.355.678-6", "20.2.249.717-1", "20.8.745.500-7"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERioGrandeDoNorteValidator(messageProducer, isFormatted);
	}

	@Test
	@Override
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = validUnformattedStringWithTenDigits + "5";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}
		verify(messageProducer, times(1)).getMessage(IEError.INVALID_DIGITS);
	}

}
