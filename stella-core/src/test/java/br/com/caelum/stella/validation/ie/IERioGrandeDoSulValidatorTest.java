package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IERioGrandeDoSulValidatorTest extends IEValidatorTest {

	public IERioGrandeDoSulValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String validFormattedString = "224/3658792";
	private static final String validUnformattedString = "2243658792";
	private static final String wrongCheckDigitUnformattedString = "2243658791";
	
	private static final String[] validValues = { validFormattedString, "050/0068836", "224/3224326", "468/0001479" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERioGrandeDoSulValidator(messageProducer, isFormatted);
	}
}
