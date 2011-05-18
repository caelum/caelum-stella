package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IESantaCatarinaValidatorTest extends IEValidatorTest {

	public IESantaCatarinaValidatorTest() {
		super(wrongCheckDigitString, validUnformattedString, validString, validValues);
	}

	private static final String wrongCheckDigitString = "251040858";
	private static final String validUnformattedString = "251040852";
	private static final String validString = "251.040.852";
	// TODO adicionar mais IE validos para SantaCatarina
	private static final String[] validValues = { validString };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IESantaCatarinaValidator(messageProducer, isFormatted);
	}

}
