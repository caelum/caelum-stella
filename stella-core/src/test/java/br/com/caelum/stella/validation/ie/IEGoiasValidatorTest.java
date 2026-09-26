package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;


public class IEGoiasValidatorTest extends IEValidatorTest {

    public IEGoiasValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "109876542";

    private static final String validUnformattedString = "109876547";

    private static final String validFormattedString = "10.987.654-7";

    private static final String[] validValues = { validFormattedString, "10.103.119-0", "20.003.152-0" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEGoiasValidator(messageProducer, isFormatted);
	}

	@Test
	public void shouldRejectTheOldGoiasRemainderOneExceptions() {
		Validator<String> validator = getValidator(messageProducer, true);
		for (String oldValue : new String[] { "10.103.119-1", "11.094.402-1" }) {
			try {
				validator.assertValid(oldValue);
				fail(oldValue);
			} catch (InvalidStateException e) {
				assertEquals(1, e.getInvalidMessages().size());
			}
		}
	}

}
