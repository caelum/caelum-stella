package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

public class InscricaoEstatudalDeSaoPauloParaProdutorRuralValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);
		try {
			validator.assertValid("P12345678*012");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);
		try {
			validator.assertValid("P12345678901");
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);

		String value = "P1234567890123";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithCheckDigitsWithCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_CHECK_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);
		
		// VALID IE = P-01100424.3/002 
		String value = "P011004245002";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}

		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		// VALID IE = P-01100424.3/002 
		String value = "P011004243002";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getInvalidMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateNullIE() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		mockery.checking(new Expectations(){{
			
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		String value = null;
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getInvalidMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldValidateValidFormattedIE(){
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				
			}
		});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID IE = P-01100424.3/002 
		String value = "P-01100424.3/002";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.getInvalidMessages(value);
		assertTrue(errors.isEmpty());
		
		mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateValidUnformattedIE(){
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery
				.mock(MessageProducer.class);

		mockery.checking(new Expectations() {
			{
				exactly(1).of(messageProducer).getMessage(
						IEError.INVALID_FORMAT);
			}
		});
		Validator validator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(messageProducer,true);

		// VALID IE = P-01100424.3/002 
		String value = "Q-01100424.3/002";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

}
