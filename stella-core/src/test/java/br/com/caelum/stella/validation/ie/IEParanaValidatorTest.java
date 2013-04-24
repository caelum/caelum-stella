package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEParanaValidatorTest extends IEValidatorTest {

	public IEParanaValidatorTest() {
		super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongFirstCheckDigitUnformattedString = "1234567860";
	
	private static final String wrongSecondCheckDigitUnformattedString = "1234567859";
	
	private static final String validUnformattedString = "1234567850";
	
	private static final String validFormattedString = "099.00004-09";
	
	private static final String[] validValues = { "099.00004-09", "123.45678-50", "826.01749-09", "902.33203-01",
		"738.00291-16", "738.00294-69", "738.00302-03", "738.00313-66", "738.00338-14", "738.00348-96", "90258216-93"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEParanaValidator(messageProducer, isFormatted);
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
