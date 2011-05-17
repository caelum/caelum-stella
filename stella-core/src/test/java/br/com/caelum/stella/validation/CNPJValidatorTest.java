package br.com.caelum.stella.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.error.CNPJError;

/**
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class CNPJValidatorTest {

    private final String validString = "26.637.142/0001-58";

    private final String firstCheckDigitWrong = "26.637.142/0001-68";

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
        new CNPJValidator().assertValid(validString);

        try {
            new CNPJValidator().assertValid(firstCheckDigitWrong);
        } catch (RuntimeException e) {
            if (e instanceof InvalidStateException) {
                InvalidStateException invalidStateException = (InvalidStateException) e;
                String expected = "CNPJError : INVALID CHECK DIGITS";
                assertEquals(expected, invalidStateException.getInvalidMessages().get(0).getMessage());
            } else {
                fail();
            }
        }
    }

    @Test
    public void shouldNotValidateCNPJWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_DIGITS);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, false);
        try {
            String value = "1234567890123";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }
    
    @Test
    public void shouldNotValidateCNPJWithMoreDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_DIGITS);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, false);
        try {
            String value = "123456789012345";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateCNPJWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_DIGITS);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, false);
        try {
            String value = "1111111a111111";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldValidateValidCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator<String> validator = new CNPJValidator(messageProducer, false);

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

    @Test
    public void shoulValidateNullCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator<String> validator = new CNPJValidator(messageProducer, false);

        try {
            String value = null;
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateCNPJCheckDigitsWithFirstCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, false);
        // VALID CNPJ = 742213250001-30
        try {
            String value = "74221325000160";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldNotValidateCNPJCheckDigitsWithSecondCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_CHECK_DIGITS);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, false);

        // VALID CNPJ = 266371420001-58
        try {
            String value = "26637142000154";
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldValidateValidFormattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations());
        Validator<String> validator = new CNPJValidator(messageProducer, true);

        try {
            String value = validString;
            validator.assertValid(value);
        } catch (InvalidStateException e) {
            fail();
        }
        mockery.assertIsSatisfied();
    }

    @Test(expected = InvalidStateException.class)
    public void shouldNotValidateValidUnformattedCNPJ() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(CNPJError.INVALID_FORMAT);
            }
        });
        Validator<String> validator = new CNPJValidator(messageProducer, true);

        // VALID CNPJ = 26.637.142/0001-58
        try {
            String value = "26637142000158";
            validator.assertValid(value);
            fail();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            mockery.assertIsSatisfied();
        }
    }

}
