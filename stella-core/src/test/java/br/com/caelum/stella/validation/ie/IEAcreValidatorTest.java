package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IEAcreValidatorTest extends IEValidatorTest {

	/*
	 * Formato Antigo : ???
	 * 
	 * Formato Novo: 11 dígitos+2 dígitos verificadores
	 * 
	 * Os primeiros dois dígitos são sempre 01
	 * 
	 * Exemplo: Inscrição Estadual 01.004.823/001-12
	 * 
	 * 01.004.141/001-46
	 * 
	 * 01.001.349/001-77
	 */

	public IEAcreValidatorTest() {
		super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
	}

	private static final String wrongCheckDigitUnformattedNewString = "0100482300115";

	private static final String validUnformattedNewString = "0100482300112";

	private static final String validFormattedNewString = "01.004.823/001-12";

	private static final String[] validValues = { validFormattedNewString, "01.004.141/001-46", "01.001.349/001-77",
			"01.956.867/001-07" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return IEValidators.ACRE.build(messageProducer, isFormatted);
	}

}
