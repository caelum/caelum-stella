package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.RenavamValidator;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public abstract class IEValidatorTest {
	protected final MessageProducer messageProducer = mock(MessageProducer.class);

	private final String wrongCheckDigitUnformattedIE;

	private final String validUnformattedIE;

	private final String validFormattedIE;

	private final String[] validFormattedValues;

	public IEValidatorTest(String wrongCheckDigitUnformattedIE, String validUnformattedIE,
			String validFormattedIE, String[] validFormattedValues) {
		super();
		this.wrongCheckDigitUnformattedIE = wrongCheckDigitUnformattedIE;
		this.validUnformattedIE = validUnformattedIE;
		this.validFormattedIE = validFormattedIE;
		this.validFormattedValues = validFormattedValues;
	}

	protected abstract Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted);

	@Test
	public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
		try {
			getValidator(messageProducer, true).assertValid(validFormattedIE);
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
			validator.assertValid(validUnformattedIE.replaceFirst(".", "&"));
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(1)).getMessage(IEError.INVALID_DIGITS);
	}

	@Test
	public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		Validator<String> validator = getValidator(messageProducer, false);
		try {
			validator.assertValid(validUnformattedIE.replaceFirst(".", ""));
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(1)).getMessage(IEError.INVALID_DIGITS);
	}

	@Test
	// IEMatoGrosso, IERioGrandeDoNorte e IEBahia sobreescrevem
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = validUnformattedIE + "5";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}
		verify(messageProducer, times(1)).getMessage(IEError.INVALID_DIGITS);
	}

	@Test
	public void shouldNotValidateIEsWithCheckDigitWrong() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = wrongCheckDigitUnformattedIE;
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(1)).getMessage(IEError.INVALID_CHECK_DIGITS);
	}

	@Test
	public void shouldValidateValidIE() {
		Validator<String> validator = getValidator(messageProducer, true);

		for (String validValue : validFormattedValues) {
			try {
				validator.assertValid(validValue);
			} catch (InvalidStateException e) {
				fail("IE inválida: " + validValue);
			}
			List<ValidationMessage> errors = validator.invalidMessagesFor(validValue);
			assertTrue(errors.isEmpty());
		}

		verify(messageProducer, never()).getMessage(any(IEError.class));

	}

	@Test
	public void shouldValidateValidFormattedNovaIE() {
		Validator<String> validator = getValidator(messageProducer, true);

		String[] validValues = { validFormattedIE };
		for (String validValue : validValues) {
			try {
				validator.assertValid(validValue);
			} catch (InvalidStateException e) {
				fail("IE inválida: " + validValue);
			}
			List<ValidationMessage> errors = validator.invalidMessagesFor(validValue);
			assertTrue(errors.isEmpty());
		}

		verify(messageProducer, never()).getMessage(any(IEError.class));
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

		verify(messageProducer, never()).getMessage(any(IEError.class));
	}

	@Test
	public void shouldNotValidateValidUnformattedIE() {
		Validator<String> validator = getValidator(messageProducer, true);

		String value = validFormattedIE.replace('-', ':');
		if(value.equals(validFormattedIE)) {
			value = value.replace('/', ':');
			if(value.equals(validFormattedIE)) {
				value = value.replace('.', ':');
			}
		}
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertEquals(1, e.getInvalidMessages().size());
		}

		verify(messageProducer, times(1)).getMessage(IEError.INVALID_FORMAT);
	}

    @Test
    public void shouldGenerateValidFormattedIE() {
        final Validator<String> ieValidator = getValidator(messageProducer, true);
        final String generated = ieValidator.generateRandomValid();
        ieValidator.assertValid(generated);
    }

    @Test
    public void shouldGenerateValidUnformattedIE() {
        final Validator<String> ieValidator = getValidator(messageProducer, false);
        final String generated = ieValidator.generateRandomValid();
        ieValidator.assertValid(generated);
    }
}
