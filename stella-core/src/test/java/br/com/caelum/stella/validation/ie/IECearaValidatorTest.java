package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IECearaValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 8 dígitos+1 dígito verificador
	 * 
	 * Exemplo: CGF número 06.000.001-5 Exemplo Formatado: 06.998.161-2
	 */

	public IECearaValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "060000010";

	private static final String validUnformattedString = "060000015";

	private static final String validFormattedString = "06.000.001-5";
	private static final String[] validValues = { "06.998.161-2", "06.864.509-0", "06.031.909-7", "06.000001-5" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IECearaValidator(messageProducer, isFormatted);
	}
}
