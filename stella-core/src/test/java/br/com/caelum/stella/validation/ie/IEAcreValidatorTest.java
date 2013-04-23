package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEAcreValidatorTest extends IEValidatorTest {

	public IEAcreValidatorTest() {
		super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
	}

	private static final String wrongCheckDigitUnformattedNewString = "0100482300115";

	private static final String validUnformattedNewString = "0100482300112";

	private static final String validFormattedNewString = "01.004.823/001-12";

	private static final String[] validValues = { validFormattedNewString, "01.004.141/001-46", "01.001.349/001-77",
			"01.956.867/001-07", "01.379.333/036-16", "01.367.306/773-60", "01.658.566/892-98", "01.689.555/741-67" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEAcreValidator(messageProducer, isFormatted);
	}

}
