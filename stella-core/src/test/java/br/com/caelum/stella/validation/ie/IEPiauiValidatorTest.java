package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEPiauiValidatorTest extends IEValidatorTest {

	public IEPiauiValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "193016560";

	private static final String validUnformattedString = "193016567";

	private static final String validFormattedString = "19.301.656-7";

	private static final String[] validValues = { validFormattedString , "16.907.872-8", "81.806.022-0"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPiauiValidator(messageProducer, isFormatted);
	}
}
