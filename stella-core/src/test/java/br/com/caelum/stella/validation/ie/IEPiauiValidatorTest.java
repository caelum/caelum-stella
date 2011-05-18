package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEPiauiValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 8 dígitos (empresa)+1 dígito verificador Exemplo: 19.301.656-7
	 */

	public IEPiauiValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "193016560";

	private static final String validUnformattedString = "193016567";

	private static final String validFormattedString = "19.301.656-7";

	private static final String[] validValues = { validFormattedString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPiauiValidator(messageProducer, isFormatted);
	}
}
