package br.com.caelum.stella.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

/**
 * @author Leonardo Bessa
 */
public class CPFValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		try {
			validator.assertValid("1111111a111");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		try {
			validator.assertValid("1234567890");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);

		String value = "123456789012";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithCheckDigitsWithFirstCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_CHECK_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
		// VALID CPF = 248.438.034-80
		String value = "24843803470";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithCheckDigitsWithSecondCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.INVALID_CHECK_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
		// VALID CPF = 099.075.865-60
		String value = "09907586561";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}

		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidCPF() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		
		String value = "88641577947";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		value = "34608514300";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		value = "47393545608";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateNullCPF() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		String value = null;
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateCPFWithAllRepeatedDigitsFaulWhenNotIgnoringIt() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(CPFError.REPEATED_DIGITS);
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false,false);
		
		String value = "44444444444";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateCPFWithAllRepeatedDigitsFaulWhenIgnoringIt() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		CPFValidator validator = new CPFValidator(messageProducer,false);
		List<ValidationMessage> errors;
		
		String value = "44444444444";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedCPF(){
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				
			}
		});
		CPFValidator validator = new CPFValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID CPF = 356.296.825-63
		String value = "356.296.825-63";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getValidationMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateValidUnformattedCPF(){
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						CPFError.INVALID_FORMAT);
			}
		});
		CPFValidator validator = new CPFValidator(messageProducer,true);

		// VALID CPF = 332.375.322-40
		String value = "332.375.32240";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getValidationMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

}
