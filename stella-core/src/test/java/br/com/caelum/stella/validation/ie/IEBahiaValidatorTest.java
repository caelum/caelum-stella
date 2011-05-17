package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEBahiaValidatorTest extends IEValidatorTest {

	/*
	 * 612345-57
	 * 
	 * 123456-63
	 */

	private static final String wrongCheckDigitUnformattedNewString = "61234559";

	private static final String validUnformattedNewString = "61234557";

	private static final String validFormattedNewString = "612345-57";

	private static final String[] validValues = { validFormattedNewString, "123456-63" };

	protected Validator<String> newValidator() {
		return new IEBahiaValidator();
	}

	public IEBahiaValidatorTest() {
		super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
	}

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEBahiaValidator(messageProducer, isFormatted);
	}

}
