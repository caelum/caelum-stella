package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IERondoniaValidatorCasoUmTest extends IEValidatorTest {

	public IERondoniaValidatorCasoUmTest() {
		super(wrongCheckDigitUnformatted, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformatted = "200400403";

	private static final String validUnformattedString = "200400401";

	private static final String validFormattedString = "101.62521-3";

	private static final String[] validValues = { "101.62521-3", "101.20010-7", "101.91080-5", "101.54055-2",
			"203.01019-7", "403.51417-9", "209.49504-2", "109.47520-3", "401.51033-5", "203.40481-1" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERondoniaCasoUmValidator(messageProducer, isFormatted);
	}
}
