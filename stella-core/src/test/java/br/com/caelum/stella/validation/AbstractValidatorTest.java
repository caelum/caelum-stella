package br.com.caelum.stella.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

public class AbstractValidatorTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testGetValidationMessagesT() {
		 Mockery mockery = new Mockery();
	        final MessageProducer messageProducer = mockery
	                .mock(MessageProducer.class);
	        final InvalidValue invalidValue = mockery.mock(InvalidValue.class);
	        final ValidationMessage validationMessage = mockery.mock(ValidationMessage.class);
	        final Object any = new Object();

	        mockery.checking(new Expectations() {
	            {
	                exactly(1).of(messageProducer).getMessage(invalidValue);
					will(returnValue(validationMessage));
	            }
	        });
	        Validator validator = new AbstractValidator(messageProducer){

				@Override
				protected List<InvalidValue> getInvalidValues(Object value) {
					assertEquals(value, any);
					ArrayList<InvalidValue> invalidValues = new ArrayList<InvalidValue>();
					invalidValues.add(invalidValue);
					return invalidValues;
				}
	        	
	        };
			List<ValidationMessage> messages0 = validator.invalidMessagesFor(any);
			List<ValidationMessage> messages1 = new ArrayList<ValidationMessage>();
			messages1.add(validationMessage);
			assertEquals(messages0, messages1);
	       

	        mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAssertValidShouldThrowInvalidStateExpectionWhenComesAnInvalidValue() {
		 Mockery mockery = new Mockery();
	        final MessageProducer messageProducer = mockery
	                .mock(MessageProducer.class);
	        final InvalidValue invalidValue = mockery.mock(InvalidValue.class);
	        final ValidationMessage validationMessage = mockery.mock(ValidationMessage.class);
	        final Object any = new Object();

	        mockery.checking(new Expectations() {
	            {
	                exactly(1).of(messageProducer).getMessage(invalidValue);
					will(returnValue(validationMessage));
	            }
	        });
	        Validator validator = new AbstractValidator(messageProducer){

				@Override
				protected List<InvalidValue> getInvalidValues(Object value) {
					assertEquals(value, any);
					ArrayList<InvalidValue> invalidValues = new ArrayList<InvalidValue>();
					invalidValues.add(invalidValue);
					return invalidValues;
				}
	        	
	        };
	        try {
				validator.assertValid(any);
				fail();
			} catch (InvalidStateException e) {
				List<ValidationMessage> messages0 = e.getInvalidMessages();
				List<ValidationMessage> messages1 = new ArrayList<ValidationMessage>();
				messages1.add(validationMessage);
				assertEquals(messages0, messages1);
			} catch (Exception e){
				fail();
			}

	        mockery.assertIsSatisfied();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAssertValidShouldNotThrowInvalidStateExpectionWhenValueIsValid() {
		 Mockery mockery = new Mockery();
	        final MessageProducer messageProducer = mockery
	                .mock(MessageProducer.class);
	        final Object any = new Object();

	        mockery.checking(new Expectations() {
	            {
	            }
	        });
	        Validator validator = new AbstractValidator(messageProducer){

				@Override
				protected List<InvalidValue> getInvalidValues(Object value) {
					assertEquals(value, any);
					ArrayList<InvalidValue> empty = new ArrayList<InvalidValue>();
					return empty;
				}
	        	
	        };
	        try {
				validator.assertValid(any);
			} catch (InvalidStateException e) {
				fail();
			}

	        mockery.assertIsSatisfied();
	}

}
