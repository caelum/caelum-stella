package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEMatoGrossoDoSulValidatorTest extends IEValidatorTest {

	public IEMatoGrossoDoSulValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "283037591";

	private static final String validUnformattedString = "283037598";

	private static final String validFormattedString = "28.303.759-8";
	
	private static final String[] validValues = { validFormattedString, "28.322.235-2", "28.301.273-0", 
		"28.288.890-0", "28.226.590-2", "28.296.665-0", "28.303.740-7", "28.306.701-2", "28.071.810-1", 
		"28.311.591-2", "28.098.983-0", "28.316.487-5", "28.639.242-9", "28.330.011-6", "28.211.197-2" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEMatoGrossoDoSulValidator(messageProducer, isFormatted);
	}

}
