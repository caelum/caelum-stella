package br.com.caelum.stella;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.validator.CNPJError;
import br.com.caelum.stella.validator.CNPJValidator;

/**
 * @Author Leonardo Bessa
 */
public class CNPJValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateDigitsMissMatch() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(3).of(messageProducer).getMessage(
						CNPJError.DIGITS_MISSMATCH);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890123"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("123456789012345"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("1111111a111111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateValidCNPJ() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer);

		List<ValidationMessage> errors;

		assertTrue(validator.validate("63025530002409"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());

		assertTrue(validator.validate("61519128000150"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());

		assertTrue(validator.validate("68745386000102"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());

		assertTrue(validator.validate("15208211000191"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());

		assertTrue(validator.validate("75252952000100"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateAllRepeatedDigitsFaul() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{
				exactly(10).of(messageProducer).getMessage(
						CNPJError.ALL_REPEATED_DIGITS_FAUL);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("11111111111111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("22222222222222"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("33333333333333"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("44444444444444"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("55555555555555"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("66666666666666"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("77777777777777"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("88888888888888"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("99999999999999"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("00000000000000"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateNull() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer);

		List<ValidationMessage> errors;
		assertTrue(validator.validate(null));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateCheckDigits() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(6).of(messageProducer).getMessage(
						CNPJError.CHECK_DIGITS_MISSMATCH);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("85475820000193"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("62436601000197"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("24542848000122"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("21434696000143"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("81085255000114"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("58756334000172"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

}
