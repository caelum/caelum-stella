package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEAmapaValidatorTest extends IEValidatorTest {

	public IEAmapaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "030123450";

	private static final String validUnformattedString = "030123459";

	private static final String validFormattedString = "03.012.345-9";

	private static final String[] validValues = { validFormattedString, "03.002.547-3", "03.002547-3" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEAmapaValidator(messageProducer, isFormatted);
	}
}
