package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEEspiritoSantoValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 8 dígitos (empresa)+1 dígito verificador
	 * 
	 * Exemplo: 082.223.54-8
	 */

	private static final String wrongCheckDigitUnformattedString = "082223540";

	private static final String validUnformattedString = "082223548";

	private static final String validFormattedString = "082.223.54-8";

	private static String[] validUnformattedValues = new String[] { validFormattedString, "082.260.66-4",
			"081.877.45-5" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEEspiritoSantoValidator(messageProducer, isFormatted);
	}

	public IEEspiritoSantoValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validUnformattedValues);
	}

}
