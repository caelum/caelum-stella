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

public class InscricaoEstatudalDeSaoPauloValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		try {
			validator.assertValid("1234567a9012");
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		try {
			validator.assertValid("12345678901");
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);

		String value = "1234567890123";
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
	public void shouldNotValidateIEWithCheckDigitsWithFirstCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_CHECK_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		
		// VALID IE = 110.042.490.114 
		String value = "110042490104";
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
	public void shouldNotValidateIEWithCheckDigitsWithSecondCheckDigitWrong() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_CHECK_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		
		// VALID IE = 110.042.490.114 
		String value = "110042490118";
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		
		String value = "110042490114";
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,false);
		
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID IE = 110.042.490.114
		String value = "110.042.490.114";
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
		Validator validator = new InscricaoEstatudalDeSaoPauloValidator(messageProducer,true);

		// VALID IE = 110.042.490.114
		String value = "110.0424.490.114";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

}
