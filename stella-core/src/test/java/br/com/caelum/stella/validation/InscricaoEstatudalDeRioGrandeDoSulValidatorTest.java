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

public class InscricaoEstatudalDeRioGrandeDoSulValidatorTest {
	
	// validUnforamtedIE = "2243658792";
	// validFormatedIE = "224/3658792";

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotValidateIEWithInvalidCharacter() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
		}});
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		try {
			validator.assertValid("1234-67890");
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		try {
			validator.assertValid("123456789");
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);

		String value = "12345678901";
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		
		// VALID IE = 224/3658792
		String value = "2243658793";
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
	public void shouldNotValidateIEWithInvalidMunicipality() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_MUNICIPALITY);
		}});
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		
		// VALID IE = 224/3658792
		String value = "4683658797";
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
	public void shouldNotValidateIEWithInvalidMunicipalityWithZeros() {
		Mockery mockery = new Mockery();
		final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
		
		mockery.checking(new Expectations(){{
			exactly(1).of(messageProducer).getMessage(IEError.INVALID_MUNICIPALITY);
		}});
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		
		// VALID IE = 224/3658792
		String value = "0003658791";
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		
		List<ValidationMessage> errors;
		
		// VALID IE = 224/3658792
		String value = "2243658792";
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,false);
		
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,true);
		List<ValidationMessage> errors;

		// VALID IE = 224/3658792
		String value = "224/3658792";
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
		Validator validator = new InscricaoEstatudalDeRioGrandeDoSulValidator(messageProducer,true);

		// VALID IE = 224/3658792
		String value = "224*3658792";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size()==1);
		}
		
		mockery.assertIsSatisfied();
	}

}
