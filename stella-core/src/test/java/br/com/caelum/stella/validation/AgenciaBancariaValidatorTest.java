package br.com.caelum.stella.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.error.AgenciaBancariaError;

/**
 * @author Thiago Nascimento
 */
public class AgenciaBancariaValidatorTest {

	private MessageProducer messageProducer = new SimpleMessageProducer();
	
	@Test
	public void shouldAcceptEligibleAgenciasComDV() {
		AgenciaBancariaValidator validator = new AgenciaBancariaValidator();
		assertTrue(validator.isEligible("3610-2"));
		assertFalse(validator.isEligible("3610"));
	}
	
	@Test
	public void shouldAcceptEligibleAgenciasSemDV() {
		AgenciaBancariaValidator validator = new AgenciaBancariaValidator(false);
		assertFalse(validator.isEligible("3610-2"));
		assertTrue(validator.isEligible("3610"));
	}
	
	@Test
	public void shouldReturnNoValidationMessagesForCorrectAgenciasComDV() {
		AgenciaBancariaValidator validator = new AgenciaBancariaValidator();
		assertTrue(validator.invalidMessagesFor("3610-2").isEmpty());
		assertTrue(validator.invalidMessagesFor("3793-1").isEmpty());
		assertTrue(validator.invalidMessagesFor("197-X").isEmpty());
		assertTrue(validator.invalidMessagesFor("4158-0").isEmpty());
		assertTrue(validator.invalidMessagesFor("2121-0").isEmpty());
		assertTrue(validator.invalidMessagesFor("1284-X").isEmpty());
	}
	
	@Test
	public void shouldReturnInvalidCheckDigitForIncorrectDV() {
		
		AgenciaBancariaValidator validator = new AgenciaBancariaValidator();
		
		try {
			validator.assertValid("2121-9");
			fail();
		} catch (InvalidStateException e) {
			e.getInvalidMessages().contains(this.messageProducer.getMessage(AgenciaBancariaError.INVALID_CHECK_DIGIT));
		}
	}
	
	@Test
	public void shouldReturnCheckDigitNotFoundForAgenciaSemDV() {
		
		AgenciaBancariaValidator validator = new AgenciaBancariaValidator();
		
		try {
			validator.assertValid("1103");
			fail();
		} catch (InvalidStateException e) {
			e.getInvalidMessages().contains(this.messageProducer.getMessage(AgenciaBancariaError.CHECK_DIGIT_NOT_FOUND));
		}
	}
}
