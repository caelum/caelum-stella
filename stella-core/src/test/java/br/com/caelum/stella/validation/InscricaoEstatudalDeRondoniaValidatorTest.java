package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.IEError;

public class InscricaoEstatudalDeRondoniaValidatorTest {

	/*
	 * IE validas 00000001721593 00000001721585 00000001721577 00000001721097
	 * 00000001721569 00000001721551 00000001721542 00000001721534
	 * 00000001721526 00000001721518 00000001721283 00000001721267
	 * 00000001721500 00000001721496 00000001721488 00000001721470
	 * 00000001721461 00000001721453 00000001721411 00000001721313
	 * 00000001721445 00000001721437
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_DIGITS);
			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);
		try {
			validator.assertValid("172j518");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_DIGITS);
			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);
		try {
			validator.assertValid("172151");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_DIGITS);
			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);

		String value = "17215184";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithCheckDigitsWithCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_CHECK_DIGITS);
			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);

		// VALID IE = 00000001721593
		String value = "00000001721597";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);

		List<ValidationMessage> errors;

		String[] validValues = { "101625213", "00000001721593",
				"00000001721585", "00000001721577", "00000001721097",
				"00000001721569", "00000001721550", "00000001721542",
				"00000001721534", "00000001721526", "00000001721518",
				"00000001721283", "00000001721267", "00000001721500",
				"00000001721496", "00000001721488", "00000001721470",
				"00000001721461", "00000001721453", "00000000587125",
				"00000001721313", "00000000437000", "00000000500461",
				"00000000587125", "00000001721313", "00000001721445",
				"00000001721437", "101200107", "101910805", "101540552",
				"203010197", "403514179", "209495042", "109475203",
				"401510335", "203404811" };
		for (String validValue : validValues) {
			try {
				validator.assertValid(validValue);
			} catch (InvalidStateException e) {
				fail();
			}
			errors = validator.invalidMessagesFor(validValue);
			assertTrue(errors.isEmpty());
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidIEButItsNot() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);

		List<ValidationMessage> errors;
		String validValueThatIsNotValidating = "00000001721411";
		try {
			validator.assertValid(validValueThatIsNotValidating);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(validValueThatIsNotValidating);
		assertTrue(errors.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateNullIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, false);

		List<ValidationMessage> errors;
		String value = null;
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
		assertTrue(errors.isEmpty());

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{

			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, true);
		List<ValidationMessage> errors;

		// VALID IE = 101.62521-3
		String value = "101.62521-3";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
		assertTrue(errors.isEmpty());

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateValidUnformattedIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_FORMAT);
			}
		});
		Validator validator = new InscricaoEstatudalDeRondoniaValidator(
				messageProducer, true);

		// VALID IE = 101.62521-3
		String value = "101.62521*3";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}

		mockery.assertIsSatisfied();
	}

}
