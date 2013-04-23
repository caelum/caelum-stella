package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEAlagoasValidatorTest extends IEValidatorTest {

	public IEAlagoasValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "240000040";

	private static final String validUnformattedString = "240000048";

	private static final String validFormattedString = "24.000.004-8";

	private static final String[] validValues = { "24.076.739-0", "24.103.644-5", "24.089.826-5", "24.099.991-6",
			"24.067.173-2", "24.102.358-0", "24.079.990-9", "24.089.451-0", "24.080.152-0", "24.092.497-5",
			"24.095.056-9", "24.099.899-5", "24.104.510-0", "24.069.666-2", "24.088.932-0", "24.097.262-7",
			"24.086.162-0", "24.097.871-4", "24.085.016-5", "24.073.874-8", "24.071.760-0", "24.065.706-3",
			"24.054.337-8", "24.102.324-6", "24.105.106-1", "24.104.536-3", "24.086.313-5", "24.089.826-5" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEAlagoasValidator(messageProducer, isFormatted);
	}

}
