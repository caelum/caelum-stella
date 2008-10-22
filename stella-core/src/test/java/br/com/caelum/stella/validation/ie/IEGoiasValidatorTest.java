package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEGoiasValidatorTest {

    /*
     * Formato da Inscrição: AB.CDE.FGH-I 8 dígitos (ABCDEFGH)+1 dígito
     * verificador (I); onde AB pode ser igual a 10 ou 11 ou 15.
     * 
     * CCE de Exemplo: 10.987.654-7
     * 
     * -Atribui-se um peso a cada dígito do CCE seguindo a ordem abaixo:
     * 
     * CCE= 1 0 9 8 7 6 5 4
     * 
     * PESOS= 9 8 7 6 5 4 3 2
     * 
     * 
     * Cálculo:
     * 
     * (9x1)+(8x0)+(7x9)+(6x8)+(5x7)+(4x6)+(3x5)+(2x4)= 202
     * 
     * Divide-se 202 por 11= 18 e sobra 4 (resto)
     * 
     * Quando a inscrição for 11094402 o dígito verificador pode ser zero (0) e
     * pode ser um (1);
     * 
     * Quando o resto da divisão for zero (0), o dígito verificador será zero
     * (0);
     * 
     * Quando o resto da divisão for um (1), e a inscrição for maior ou igual a
     * 10103105 e menor ou igual a 10119997, o dígito verificador será um (1);
     * 
     * Quando o resto da divisão for um (1), e a inscrição estiver fora do
     * intervalo citado acima, o dígito verificador será zero (0);
     * 
     * Quando o resto for diferente de um (1) ou zero (0), o dígito verificador
     * será onze (11) menos o resto. No exemplo acima onze (11) menos quatro (4)
     * é igual a sete (7) que é o dígito verificador da Inscrição 10.987.654-7
     */

    private static final String wrongCheckDigitUnformattedString = "109876542";

    private static final String validUnformattedString = "109876547";

    private static final String validFormattedString = "10.987.654-7";

    private static final String[] validValues = { validFormattedString, "10.103.119-1" };

    private Validator<String> newValidator() {
        return new IEGoiasValidator();
    }

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
        newValidator().assertValid(validFormattedString);

        try {
            newValidator().assertValid(validFormattedString);
        } catch (RuntimeException e) {
            if (e instanceof InvalidStateException) {
                InvalidStateException invalidStateException = (InvalidStateException) e;
                String expected = "IEError : INVALID CHECK DIGITS";
                assertEquals(expected, invalidStateException.getInvalidMessages().get(0).getMessage());
            } else {
                fail();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithInvalidCharacter() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new IEGoiasValidator(messageProducer, false);
        try {
            validator.assertValid(validUnformattedString.replaceFirst(".", "&"));
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithLessDigitsThanAllowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new IEGoiasValidator(messageProducer, false);
        try {
            validator.assertValid(validUnformattedString.replaceFirst(".", ""));
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_DIGITS);
            }
        });
        Validator validator = new IEGoiasValidator(messageProducer, false);

        String value = validUnformattedString + "5";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldNotValidateIEsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new IEGoiasValidator(messageProducer, false);

        String value = wrongCheckDigitUnformattedString;
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, true);

        List<ValidationMessage> errors;

        for (String validValue : validValues) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateMagicNumberValidUnformattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "110944020", "110944021" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateMagicNumberValidFormattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, true);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "11.094.402-0", "11.094.402-1" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValidFormattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, true);

        List<ValidationMessage> errors;

        String[] validValues = { validFormattedString };
        for (String validValue : validValues) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }
        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateNullIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

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
    public void shouldNotValidateValidUnformattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_FORMAT);
            }
        });
        Validator validator = new IEGoiasValidator(messageProducer, true);

        String value = validFormattedString.replace('.', ':');
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateLowerBoundary() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "101031051" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateUpperBoundary() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "101199971" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValuesThatAreLesserThan101031050() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "101031041", "101030860" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldValidateValuesThatAreGreaterThan101199979() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);
        mockery.checking(new Expectations());
        Validator validator = new IEGoiasValidator(messageProducer, false);

        List<ValidationMessage> errors;

        for (String validValue : new String[] { "101199988" }) {
            try {
                validator.assertValid(validValue);
            } catch (InvalidStateException e) {
                fail();
            }
            errors = validator.invalidMessagesFor(validValue);
            assertTrue(errors.isEmpty());
        }

        mockery.assertIsSatisfied();
    }

}
