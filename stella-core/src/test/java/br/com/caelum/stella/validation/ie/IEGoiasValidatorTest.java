package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;


public class IEGoiasValidatorTest extends IEValidatorTest {

    public IEGoiasValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "109876542";

    private static final String validUnformattedString = "109876547";

    private static final String validFormattedString = "10.987.654-7";

    private static final String[] validValues = { validFormattedString, "10.103.119-1", "15.368.273-6" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEGoiasValidator(messageProducer, isFormatted);
	}


}
