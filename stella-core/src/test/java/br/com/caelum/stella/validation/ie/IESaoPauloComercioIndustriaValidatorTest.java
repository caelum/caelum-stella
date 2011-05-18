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

public class IESaoPauloComercioIndustriaValidatorTest extends IEValidatorTest {

	public IESaoPauloComercioIndustriaValidatorTest() {
		super(wrongCheckDigitString, validUnformattedString, validString, validValues);
	}

	private static final String wrongCheckDigitString = "110042490104";
	private static final String wrongSecondCheckDigitString = "110042490115";
	private static final String validUnformattedString = "110042490114";
	private static final String validString = "110.042.490.114";
	// TODO adicionar mais IE validos para São Paulo
	private static final String[] validValues = { validString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IESaoPauloComercioIndustriaValidator(messageProducer, isFormatted);
	}

	@Test
	public void shouldNotValidateIEsWithSecondCheckDigitWrong() {
		Validator<String> validator = getValidator(messageProducer, false);

		try {
			validator.assertValid(wrongSecondCheckDigitString);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(1)).getMessage(IEError.INVALID_CHECK_DIGITS);
	}

}
