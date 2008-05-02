package br.com.caelum.stella.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.Validator;

/**
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class CNPJValidatorTest {

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);
        try {
        	String value = "1234567890123";
			validator.assertValid(value);
        	fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size()==1);
		}

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithMoreDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);
        try {
        	String value = "123456789012345";
			validator.assertValid(value);
        	fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size()==1);
		}

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_DIGITS);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);
        try {
        	String value = "1111111a111111";
			validator.assertValid(value);
        	fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size()==1);
		}
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations() {
            {

            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);

        try {
        	String value = "63025530002409";
			validator.assertValid(value);
        } catch (InvalidStateException e) {
        	fail();
		}
        
        try {
        	String value = "61519128000150";
			validator.assertValid(value);
        } catch (InvalidStateException e) {
        	fail();
		}
        
        try {
        	String value = "68745386000102";
			validator.assertValid(value);
        } catch (InvalidStateException e) {
        	fail();
		}

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shoulValidateNullCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);
        mockery.checking(new Expectations() {
            {

            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);

        try {
        	String value = null;
			validator.assertValid(value);
        } catch (InvalidStateException e) {
        	fail();
		}
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJCheckDigitsWithFirstCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);
        // VALID CNPJ = 742213250001-30
        try {
        	String value = "74221325000160";
			validator.assertValid(value);
        	fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size()==1);
		}

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateCNPJCheckDigitsWithSecondCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, false);

        // VALID CNPJ = 266371420001-58
        try {
        	String value = "26637142000154";
			validator.assertValid(value);
        	fail();
        } catch (InvalidStateException e) {
        	assertTrue(e.getInvalidMessages().size()==1);
		}
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidFormattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {

            }
        });
        Validator validator = new CNPJValidator(messageProducer, true);

        // VALID CNPJ = 26.637.142/0001-58
        try {
        	String value = "26.637.142/0001-58";
			validator.assertValid(value);
        } catch (InvalidStateException e) {
        	fail();
		}
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateValidUnformattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery
                .mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(
                        CNPJError.INVALID_FORMAT);
            }
        });
        Validator validator = new CNPJValidator(messageProducer, true);

        // VALID CNPJ = 26.637.142/0001-58
        try {
        	String value = "26637142000158";
			validator.assertValid(value);
			fail();
        } catch (InvalidStateException e) {
		}

        mockery.assertIsSatisfied();
    }

}
