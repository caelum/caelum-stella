package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEDistritoFederalValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 07.408.738/002-50
	 */

	private static final String wrongFirstCheckDigitUnformattedString = "0740873800240";

	private static final String wrongSecondCheckDigitUnformattedString = "0740873800240";

	private static final String validUnformattedString = "0740873800250";

	private static final String validFormattedString = "07.408.738/002-50";

	private static final String[] validValues = {
			validFormattedString, "07.343.623/001-77", "07.451.530/001-68",
			"07.389.634/001-01", "07.336.802/001-60", "07.346.779/001-46", "07.548.137/001-52", "07.300.001/001-09",
			"07.049.826/001-24", "07.227.366/001-03", "07.803.364/001-39", "07.729.081/001-77", "07.327.328/001-05",
			"07.212.337/001-69", "07.467.791/001-42", "07.590.178/001-66", "07.756.805/001-93", "07.222.083/001-85",
			"07.862.867/001-68", "07.421.535/001-82", "07.110.853/001-87", "07.034.188/001-02", "07.948.231/001-90",
			"08.421.635/001-90", "08.421.575/001-32", "08.491.535/001-86", "08.821.535/001-88", "08.422.535/001-80"

	};

	public IEDistritoFederalValidatorTest() {
		super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEDistritoFederalValidator(messageProducer, isFormatted);
	}

	@Test
	public void shouldNotValidateIEWithSecondCheckDigitWrong() {
		Validator<String> validator = getValidator(messageProducer, false);

		try {
			validator.assertValid(wrongSecondCheckDigitUnformattedString);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_CHECK_DIGITS);
	}
}
