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

public class InscricaoEstatudalDeRioDeJaneiroValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);
		try {
			validator.assertValid("7a045302");
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);
		try {
			validator.assertValid("1234567");
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);

		String value = "123456789";
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);
		
		// VALID IE = 78.045.302
		String value = "78045303";
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		
		String value = "78045302";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		String value = null;
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID IE = 78.045.302
		String value = "78.045.302";
		try {
			validator.assertValid(value);
		} catch (InvalidStateException e) {
			fail();
		}
		errors = validator.invalidMessagesFor(value);
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
		Validator validator = new InscricaoEstatudalDeRioDeJaneiroValidator(messageProducer,true);

		// VALID IE = 78.045.302
		String value = "78.045*X302";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

}
