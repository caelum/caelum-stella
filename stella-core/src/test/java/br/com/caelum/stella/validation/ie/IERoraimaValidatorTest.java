package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IERoraimaValidatorTest extends IEValidatorTest {

	public IERoraimaValidatorTest() {
		super(wrongCheckDigitString, validUnformattedString, validString, validValues);
	}

	private static final String validString = "24004145-5";
	private static final String wrongCheckDigitString = "240041458";
	private static final String validUnformattedString = "240017556";
	
	private static final String[] validValues = { "24006628-1", "24001755-6", "24003429-0", "24001360-3", 
		"24008266-8", "24006153-6", "24007356-2", "24005467-4", "24004145-5", "24001340-7", "24444932-5" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERoraimaValidator(messageProducer, isFormatted);
	}
}
