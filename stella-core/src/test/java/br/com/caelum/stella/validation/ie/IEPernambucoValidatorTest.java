package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEPernambucoValidatorTest extends IEValidatorTest {

	public IEPernambucoValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "032141849";

	private static final String validUnformattedString = "032141840";

	private static final String validFormattedString = "0321418-40";

	private static final String[] validValues = { validFormattedString, "0000004-34" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPernambucoValidator(messageProducer, isFormatted);
	}

}
