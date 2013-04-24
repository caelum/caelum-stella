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

public class IERioGrandeDoSulValidatorTest extends IEValidatorTest {

	public IERioGrandeDoSulValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String validFormattedString = "224/3658792";
	private static final String validUnformattedString = "2243658792";
	private static final String wrongCheckDigitUnformattedString = "2243658791";
	
	private static final String[] validValues = { validFormattedString, "050/0068836", "224/3224326" };

	@Test
	public void shouldNotValidateIEWithInvalidMunicipalityWithZeros() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value1 = "0003658791";
		try {
			validator.assertValid(value1);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		String value2 = "0003658792";
		try {
			validator.assertValid(value2);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(2, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(2)).getMessage(IEError.INVALID_MUNICIPALITY);
	}

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERioGrandeDoSulValidator(messageProducer, isFormatted);
	}
}
