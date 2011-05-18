package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEPernambucoNovaValidatorTest extends IEValidatorTest {

	/*
	 * IE validas
	 * 
	 * 0321418-40 032141840
	 */

	public IEPernambucoNovaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "032141849";

	private static final String validUnformattedString = "032141840";

	private static final String validFormattedString = "0321418-40";

	// TODO Adicionar mais IE validas
	private static final String[] validValues = { validFormattedString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPernambucoNovaValidator(messageProducer, isFormatted);
	}

}
