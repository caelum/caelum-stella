package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IEMatoGrossoValidatorTest extends IEValidatorTest {

	public IEMatoGrossoValidatorTest() {
		super(wrongCheckDigitString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitString = "00132466444";

	// Este validador permite de 8 a 10 caracteres!!!
	private static final String validUnformattedString = "130152579";
	private static final String validFormattedString = "0013198872-7";
	private static final String[] validValues = { "0013193686-7", "0013193686-7", "0013053551-6", "0013056071-5",
		"0013076269-5", "0013015257-9", "0013125061-2", "0013146383-7", "0013151173-4", "0013198869-7", "0013198868-9", 
		"0013191575-4", "0013178718-7", "0013191879-6", "0013197541-2", "0013197542-0", "0013197556-0", "0013198333-4", 
		"0013198870-0", "0013198872-7", "0013205160-5", "0013199075-6", "0013199463-8", "0013198871-9", "0013199464-6", 
		"0013210743-0", "0013211337-6", "0013210747-3", "0013236559-6", "0013236558-8", "0013241890-8", "0013246644-9", 
		"0013256554-4", "0013284135-5", "0013286376-6", "0013286372-3", "13335740-6", "13329659-8", "13325238-8", 
		"13321779-5", "13316631-7", "13315986-8", "13314253-1", "13311864-9", "13307025-5", "13306973-7", "13304830-6", 
		"13303486-0", "13294120-1", "13290722-4", "13283924-5", "13281414-5", "13277927-7", "13265692-2", "13263194-6",
		"13262435-4", "13260274-1", "13249876-6", "13247098-5", "13241159-8", "13227586-4", "130365630-0","130234200-0", 
		"130181544-3", "130181541-9", "130181537-0", "130181535-4", "130181534-6", "130181533-8", "130181532-0", 
		"130181531-1", "130181530-3", "130181529-0", "130181528-1", "130181527-3", "130181526-5", "130181525-7", 
		"130181524-9", "130181523-0", "130181522-2", "130181521-4", "130181520-6", "130181519-2", "130181518-4", 
		"130181517-6", "130181516-8", "0064573571-0", "064573571-0", "64573571-0" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEMatoGrossoValidator(messageProducer, isFormatted);
	}

	@Test
	@Override
	public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		Validator<String> validator = getValidator(messageProducer, false);

		String value = validUnformattedString + "578";
		try {
			validator.assertValid(value);
			fail();
		} catch (InvalidStateException e) {
			assertTrue(e.getInvalidMessages().size() == 1);
		}
		Mockito.verify(messageProducer, Mockito.times(1)).getMessage(IEError.INVALID_DIGITS);
	}

}
