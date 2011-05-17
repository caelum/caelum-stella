package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public abstract class IEValidatorTest {
	private final MessageProducer messageProducer = Mockito.mock(MessageProducer.class);

	private final String genericWrongCheckDigitUnformattedNewString;

	private final String genericValidUnformattedNewString;

	private final String genericValidFormattedNewString;

	private final String[] genericValidFormattedValues;

	public IEValidatorTest(String wrongCheckDigitUnformattedNewString, String validUnformattedNewString,
			String validFormattedNewString, String[] validValues) {
		super();
		this.genericWrongCheckDigitUnformattedNewString = wrongCheckDigitUnformattedNewString;
		this.genericValidUnformattedNewString = validUnformattedNewString;
		this.genericValidFormattedNewString = validFormattedNewString;
		this.genericValidFormattedValues = validValues;
	}


	protected abstract Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted);

	@Test
	public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
		getValidator(messageProducer, true).assertValid(genericValidFormattedNewString);

		try {
			getValidator(messageProducer, true).assertValid(genericValidFormattedNewString);
		} catch (InvalidStateException ie) {
			String expected = "IEError : INVALID CHECK DIGITS";
			assertEquals(expected, ie.getInvalidMessages().get(0).getMessage());
		} catch (RuntimeException e) {
			fail();
		}
	}

	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Validator<String> validator = getValidator(messageProducer, false);
		try {
			validator.assertValid(genericValidUnformattedNewString.replaceFirst(".", "&"));
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_DIGITS);
	}

	@Test
	public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		Validator<String> validator = getValidator(messageProducer, false);
		try {
			validator.assertValid(genericValidUnformattedNewString.replaceFirst(".", ""));
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_DIGITS);
	}

	@Test
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = genericValidUnformattedNewString + "5";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}
		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_DIGITS);

	}

	@Test
	public void shouldNotValidateIEsWithCheckDigitWrong() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = genericWrongCheckDigitUnformattedNewString;
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_CHECK_DIGITS);
	}

	@Test
	public void shouldValidateValidIE() {
		Validator<String> validator = getValidator(messageProducer, true);

		for (String validValue : genericValidFormattedValues) {
			try {
				validator.assertValid(validValue);
			} catch (InvalidStateException e) {
				fail();
			}
			List<ValidationMessage> errors = validator.invalidMessagesFor(validValue);
			assertTrue(errors.isEmpty());
		}

		Mockito.verify(messageProducer, Mockito.never()).getMessage(Mockito.any(IEError.class));

	}

	@Test
	public void shouldValidateValidFormattedNovaIE() {
		Validator<String> validator = getValidator(messageProducer, true);

		String[] validValues = { genericValidFormattedNewString };
		for (String validValue : validValues) {
			try {
				validator.assertValid(validValue);
			} catch (InvalidStateException e) {
				fail();
			}
			List<ValidationMessage> errors = validator.invalidMessagesFor(validValue);
			assertTrue(errors.isEmpty());
		}

		Mockito.verify(messageProducer, Mockito.never()).getMessage(Mockito.any(IEError.class));
	}

	@Test
	public void shouldValidateNullIE() {
		Validator<String> validator = getValidator(messageProducer, false);
		List<ValidationMessage> errors;
		String value = null;
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
		assertTrue(errors.isEmpty());

		Mockito.verify(messageProducer, Mockito.never()).getMessage(Mockito.any(IEError.class));
	}

	@Test
	public void shouldNotValidateValidUnformattedIE() {
		MessageProducer messageProducer = Mockito.mock(MessageProducer.class);

		Validator<String> validator = getValidator(messageProducer, true);

		String value = genericValidFormattedNewString.replace('-', ':');
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_FORMAT);
	}

}
