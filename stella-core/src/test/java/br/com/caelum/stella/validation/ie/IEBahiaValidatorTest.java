package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEBahiaValidatorTest extends IEValidatorTest {

	/*
	 * 612345-57
	 * 
	 * 123456-63
	 */

	private static final String wrongCheckDigitUnformattedNewString = "61234559";

	private static final String validUnformattedNewString = "61234557";

	private static final String validFormattedNewString = "612345-57";

	private static final String[] validValues = { validFormattedNewString, "123456-63", "1000003-06","1057652-04", "0635718-30", "0770288-84", "77.028.884", "077.028.884" };

	protected Validator<String> newValidator() {
		return new IEBahiaValidator();
	}

	public IEBahiaValidatorTest() {
		super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
	}

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEBahiaValidator(messageProducer, isFormatted);
	}
	
	@Test
	@Override
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = validUnformattedNewString + "45";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}
		verify(messageProducer, times(1)).getMessage(IEError.INVALID_DIGITS);
	}

}
