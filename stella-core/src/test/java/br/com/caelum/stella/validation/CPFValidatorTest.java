package br.com.caelum.stella.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

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
		CPFValidator validator = new CPFValidator(messageProducer,false);
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
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
		CPFValidator validator = new CPFValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		assertFalse(validator.validate("44444444444"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.toString(), errors.size() == 1);		
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedCPF(){
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				
			}
		});
		CPFValidator validator = new CPFValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID CPF = 356.296.825-63
		assertTrue(validator.validate("356.296.825-63"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 0);

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldVotValidateValidUnformattedCPF(){
		Mockery mockery = new Mockery();
		final MessageProducer<CPFError> messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CPFError.INVALID_FORMAT);
			}
		});
		CPFValidator validator = new CPFValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID CPF = 332.375.322-40
		assertFalse(validator.validate("332.375.32240"));
		errors = validator.getLastValidationMessages();
		assertTrue(errors.size() == 1);

		mockery.assertIsSatisfied();
	}

}
