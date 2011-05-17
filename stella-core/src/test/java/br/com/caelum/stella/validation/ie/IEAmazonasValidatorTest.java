package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEAmazonasValidatorTest extends IEValidatorTest {

	public IEAmazonasValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "041939800";

	private static final String validUnformattedString = "041939808";

	private static final String validString = "04.193.980-8";

	private static final String[] validValues = { "04.345.678-2", "04.193.980-8", "04.133.047-1" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEAmazonasValidator(messageProducer, isFormatted);
	}
}
