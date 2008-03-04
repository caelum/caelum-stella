package br.com.caelum.stella.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

/**
 * @Author Leonardo Bessa
 */
public class CNPJValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890123"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJWithMoreDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("123456789012345"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("1111111a111111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidCNPJ() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);

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

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJWithAllRepeatedDigits() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.REPEATED_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("55555555555555"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shoulValidateNullCNPJ() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);
		mockery.checking(new Expectations() {
			{

			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);

		List<ValidationMessage> errors;
		assertTrue(validator.validate(null));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJCheckDigitsWithFirstCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_CHECK_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		// VALID CNPJ = 742213250001-30
		assertFalse(validator.validate("74221325000160"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCNPJCheckDigitsWithSecondCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_CHECK_DIGITS);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,false);
		List<ValidationMessage> errors;

		// VALID CNPJ = 266371420001-58
		assertFalse(validator.validate("26637142000154"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedCNPJ(){
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID CNPJ = 26.637.142/0001-58
		assertTrue(validator.validate("26.637.142/0001-58"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 0);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldVotValidateValidUnformattedCNPJ(){
		Mockery mockery = new Mockery();
		final MessageProducer<CNPJError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CNPJError.INVALID_FORMAT);
			}
		});
		CNPJValidator validator = new CNPJValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID CNPJ = 26.637.142/0001-58
		assertFalse(validator.validate("26637142000158"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

}
