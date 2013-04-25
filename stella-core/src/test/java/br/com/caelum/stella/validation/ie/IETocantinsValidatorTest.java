package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IETocantinsValidatorTest extends IEValidatorTest {

	public IETocantinsValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "290406360";

	private static final String validUnformattedString = "290406366";

	private static final String validFormattedString = "29.040.636-6";

	private static final String[] validValues = { validFormattedString, "29.040.634-0", "29.385.524-2", "29.032.038-0", "29.074.854-2" };
	
	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IETocantinsValidator(messageProducer, isFormatted);
	}
}
