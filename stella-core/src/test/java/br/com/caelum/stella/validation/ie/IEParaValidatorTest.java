package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEParaValidatorTest extends IEValidatorTest {

	public IEParaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "159999999";

	private static final String validUnformattedString = "159999995";

	private static final String validFormattedString = "15.999.999-5";

	private static final String[] validValues = { validFormattedString, "15.229.851-7", "15.133.081-6", "15.143.772-6",
		"15.191.809-0", "15.133.081-6", "15.105.561-0", "15.069.510-1", "15.002.934-9", "15.133.041-7", "15.887.063-8" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEParaValidator(messageProducer, isFormatted);
	}
}
