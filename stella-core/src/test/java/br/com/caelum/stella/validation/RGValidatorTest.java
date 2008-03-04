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
public class RGValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateRGWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(RGError.INVALID_DIGITS);
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		List<ValidationMessage> errors;
				
		assertFalse(validator.validate("4a9259599"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateRGWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(RGError.INVALID_DIGITS);
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateRGWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(RGError.INVALID_DIGITS);
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("12345678"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateRGWithCheckDigitsWithWrongCheckDigit() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(RGError.INVALID_CHECK_DIGITS);
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		List<ValidationMessage> errors;
		
		// VALID RG = 4499695959
		assertFalse(validator.validate("449969595"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidRG() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		
		List<ValidationMessage> errors;
		
		assertTrue(validator.validate("449969599"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		
		assertTrue(validator.validate("911225341"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateNullRG() {
		Mockery mockery = new Mockery();
		final MessageProducer<RGError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		RGValidatorForSaoPaulo validator = new RGValidatorForSaoPaulo(messageProducer);
		
		List<ValidationMessage> errors;
		assertTrue(validator.validate(null));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		mockery.assertIsSatisfied();
	}

}
