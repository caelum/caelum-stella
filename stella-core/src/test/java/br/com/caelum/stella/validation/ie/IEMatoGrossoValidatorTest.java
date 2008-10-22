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

public class IEMatoGrossoValidatorTest {

    /*
     * IE validas 0013193686-7 0013053551-6 0013056071-5 0013076269-5
     * 0013015257-9 0013125061-2 0013146383-7 0013151173-4 0013198869-7
     * 0013198868-9 0013191575-4 0013178718-7 0013191879-6 0013197541-2
     * 0013197542-0 0013197556-0 0013198333-4 0013198870-0 0013198872-7
     * 0013205160-5 0013199075-6 0013199463-8 0013198871-9 0013199464-6
     * 0013210743-0 0013211337-6 0013210747-3 0013236559-6 0013236558-8
     * 0013241890-8 0013246644-9 0013256554-4 0013284135-5 0013286376-6
     * 0013286372-3 "133357406", "133296598", "133252388", "133217795",
     * "133166317", "133159868", "133142531", "133118649", "133070255",
     * "133069737", "133048306", "133034860", "132941201", "132907224",
     * "132839245", "132814145", "132779277", "132656922", "132631946",
     * "132624354", "132602741", "132498766", "132470985", "132411598",
     * "132275864", "1303656300", "1302342000", "1301815443", "1301815419",
     * "1301815370", "1301815354", "1301815346", "1301815338", "1301815320",
     * "1301815311", "1301815303", "1301815290", "1301815281", "1301815273",
     * "1301815265", "1301815257", "1301815249", "1301815230", "1301815222",
     * "1301815214", "1301815206", "1301815192", "1301815184", "1301815176",
     * "1301815168"
     */

    private final String validString = "0013199075-6";

    private final String wrongCheckDigitString = "0013199075-6";

    private Validator<String> newValidator() {
        return new IEMatoGrossoValidator();
    }

    @Test
    public void shouldHaveDefaultConstructorThatUsesSimpleMessageProducerAndAssumesThatStringIsFormatted() {
        newValidator().assertValid(validString);

        try {
            newValidator().assertValid(wrongCheckDigitString);
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);
        try {
            validator.assertValid("00131990a56");
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);
        try {
            validator.assertValid("1234567");
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);

        String value = "123456789012345";
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
    public void shouldNotValidateIEWithCheckDigitsWithCheckDigitWrong() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations() {
            {
                exactly(1).of(messageProducer).getMessage(IEError.INVALID_CHECK_DIGITS);
            }
        });
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);

        // VALID IE = "0013199075-6"
        String value = "00131990755";
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);

        List<ValidationMessage> errors;

        String[] validValues = { "00131936867", "00131936867", "00130535516", "00130560715", "00130762695",
                "00130152579", "00131250612", "00131463837", "00131511734", "00131988697", "00131988689",
                "00131915754", "00131787187", "00131918796", "00131975412", "00131975420", "00131975560",
                "00131983334", "00131988700", "00131988727", "00132051605", "00131990756", "00131994638",
                "00131988719", "00131994646", "00132107430", "00132113376", "00132107473", "00132365596",
                "00132365588", "00132418908", "00132466449", "00132565544", "00132841355", "00132863766",
                "00132863723", "133357406", "133296598", "133252388", "133217795", "133166317", "133159868",
                "133142531", "133118649", "133070255", "133069737", "133048306", "133034860", "132941201", "132907224",
                "132839245", "132814145", "132779277", "132656922", "132631946", "132624354", "132602741", "132498766",
                "132470985", "132411598", "132275864", "1303656300", "1302342000", "1301815443", "1301815419",
                "1301815370", "1301815354", "1301815346", "1301815338", "1301815320", "1301815311", "1301815303",
                "1301815290", "1301815281", "1301815273", "1301815265", "1301815257", "1301815249", "1301815230",
                "1301815222", "1301815214", "1301815206", "1301815192", "1301815184", "1301815176", "1301815168" };
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, false);

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
    public void shouldValidateValidFormattedIE() {
        Mockery mockery = new Mockery();
        final MessageProducer messageProducer = mockery.mock(MessageProducer.class);

        mockery.checking(new Expectations());
        Validator validator = new IEMatoGrossoValidator(messageProducer, true);
        List<ValidationMessage> errors;

        // VALID IE = 0013193686-7
        String value = "0013193686-7";
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
        Validator validator = new IEMatoGrossoValidator(messageProducer, true);

        // VALID IE = 13.193.686-7
        String value = "0013193686+7";
        try {
            validator.assertValid(value);
            fail();
        } catch (InvalidStateException e) {
            assertTrue(e.getInvalidMessages().size() == 1);
        }

        mockery.assertIsSatisfied();
    }

}
