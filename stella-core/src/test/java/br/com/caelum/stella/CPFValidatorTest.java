package br.com.caelum.stella;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.validator.CPFError;
import br.com.caelum.stella.validator.CPFValidator;

/**
 * @Author Leonardo Bessa
 */
public class CPFValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS_PATTERN);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
				
		assertFalse(validator.validate("1111111a111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS_PATTERN);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS_PATTERN);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;

		assertFalse(validator.validate("123456789012"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithCheckDigitsWithFirstCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_CHECK_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		
		// VALID CPF = 248.438.034-80
		assertFalse(validator.validate("24843803470"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithCheckDigitsWithSecondCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_CHECK_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		
		// VALID CPF = 099.075.865-60
		assertFalse(validator.validate("09907586561"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidCPF() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		
		List<ValidationMessage> errors;
		
		assertTrue(validator.validate("88641577947"));
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
	public void shouldValidateNullCPF() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		
		List<ValidationMessage> errors;
		assertTrue(validator.validate(null));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.isEmpty());
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithAllRepeatedDigitsFaul() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.ALL_REPEATED_DIGITS_FAUL);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		
		assertFalse(validator.validate("44444444444"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);		
		
		mockery.assertIsSatisfied();
	}

}
