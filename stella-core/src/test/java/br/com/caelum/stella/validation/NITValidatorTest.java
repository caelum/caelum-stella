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
public class NITValidatorTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS_PATTERN);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;
				
		assertFalse(validator.validate("1111111a111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS_PATTERN);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.INVALID_DIGITS_PATTERN);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("123456789012"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithCheckDigitsWithFirstCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.INVALID_CHECK_DIGITS);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		// VALID NIT = 24.84380.348-0
		assertFalse(validator.validate("24843803470"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithCheckDigitsWithSecondCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.INVALID_CHECK_DIGITS);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		// VALID NIT = 099.075.865-60
		assertFalse(validator.validate("09907586561"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidNIT() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		
		assertTrue(validator.validate("12345678919"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		
		assertTrue(validator.validate("34608514300"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		
		assertTrue(validator.validate("47393545608"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateNullNIT() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		assertTrue(validator.validate(null));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateNITWithAllRepeatedDigitsFaul() {
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(NITError.ALL_REPEATED_DIGITS_FAUL);
		}});
		NITValidator validator = new NITValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		assertFalse(validator.validate("99999999999"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);		
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedNIT(){
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				
			}
		});
		NITValidator validator = new NITValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID NIT = 123.45678.91-9
		assertTrue(validator.validate("123.45678.91-9"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 0);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldVotValidateValidUnformattedNIT(){
		Mockery mockery = new Mockery();
		final MessageProducer<NITError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						NITError.INVALID_FORMAT);
			}
		});
		NITValidator validator = new NITValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID NIT = 12.34567.891-9
		assertFalse(validator.validate("12.34a67.891-9"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

}
