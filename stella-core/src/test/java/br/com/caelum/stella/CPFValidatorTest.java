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
	public void testValidateDigitsMissMatch() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(3).of(messageProducer).getMessage(CPFError.DIGITS_MISSMATCH);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		assertFalse(validator.validate("1234567890"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("123456789012"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		assertFalse(validator.validate("1111111a111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateCheckDigits() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(6).of(messageProducer).getMessage(CPFError.CHECK_DIGITS_MISSMATCH);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		
		assertFalse(validator.validate("22233366608"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("22233366630"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		assertFalse(validator.validate("34608514310"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		assertFalse(validator.validate("34608514301"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		assertFalse(validator.validate("47393545628"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		assertFalse(validator.validate("47393545602"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testValidateValidCpf() {
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
	public void testValidateNull() {
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
	public void testValidateAllRepeatedDigitsFaul() {
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			exactly(10).of(messageProducer).getMessage(CPFError.ALL_REPEATED_DIGITS_FAUL);
		}});
		CPFValidator validator = new CPFValidator(messageProducer);
		List<ValidationMessage> errors;
		
		assertFalse(validator.validate("11111111111"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("22222222222"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("33333333333"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("44444444444"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("55555555555"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("66666666666"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("77777777777"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);

		assertFalse(validator.validate("88888888888"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("99999999999"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		assertFalse(validator.validate("00000000000"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);
		
		mockery.assertIsSatisfied();
	}

}
