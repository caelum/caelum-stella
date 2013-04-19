package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEMaranhaoValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 8 dígitos (empresa)+1 dígito verificador
	 * 
	 * Exemplo:
	 */

	public IEMaranhaoValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "120000386";

	private static final String validUnformattedString = "120000385";

	private static final String validFormattedString = "12.000.038-5";

	private static final String[] validValues = { validFormattedString , "12.074072-9"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEMaranhaoValidator(messageProducer, isFormatted);
	}

}
