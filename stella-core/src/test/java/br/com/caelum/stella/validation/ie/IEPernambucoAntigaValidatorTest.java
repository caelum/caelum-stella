package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEPernambucoAntigaValidatorTest extends IEValidatorTest {

	/*
	 * IE validas
	 * 
	 * 18.1.001.0000004-9 18100100000049
	 */

	public IEPernambucoAntigaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "18100100000048";

	private static final String validUnformattedString = "18100100000049";

	private static final String validFormattedString = "18.1.001.0000004-9";

	// TODO Adicionar mais IE validas
	private static final String[] validValues = { validFormattedString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPernambucoAntigaValidator(messageProducer, isFormatted);
	}

}
