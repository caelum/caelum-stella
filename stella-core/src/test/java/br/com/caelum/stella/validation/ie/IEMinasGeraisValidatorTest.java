package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEMinasGeraisValidatorTest extends IEValidatorTest {

	public IEMinasGeraisValidatorTest() {
		super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongFirstCheckDigitUnformattedString = "0623079040045";
	private static final String wrongSecondCheckDigitUnformattedString = "0623079040085";
	private static final String validUnformattedString = "0623079040081";
	private static final String validFormattedString = "062.307.904/0081";
	private static final String[] validValues = { "062.307.904/0081", "702.985.547/0002", "702985547.00-02", "063543834.68-78"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEMinasGeraisValidator(messageProducer, isFormatted);
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
