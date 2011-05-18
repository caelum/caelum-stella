package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IETocantinsAntigaValidatorTest extends IEValidatorTest {

	public IETocantinsAntigaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	/*
	 * Formato: 8 dígitos (empresa)+1 dígito verificador
	 * 
	 * Exemplo valido : 29010227836
	 */

	private static final String wrongCheckDigitUnformattedString = "29010227830";

	private static final String validUnformattedString = "29010227836";

	private static final String validFormattedString = "29.01.022.783-6";

	private static final String[] validValues = { validFormattedString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IETocantinsAntigaValidator(messageProducer, isFormatted);
	}

}
