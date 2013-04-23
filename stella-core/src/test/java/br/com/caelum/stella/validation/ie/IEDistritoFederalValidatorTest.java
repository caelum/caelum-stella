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

	private static final String[] validValues = { validFormattedString, "07.343.623/001-77", "07.451.530/001-68",
			"07.389.634/001-01", "07.336.802/001-60", "07.346.779/001-46", "07.548.137/001-52", "07.300.001/001-09" };

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
