package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IESaoPauloProdutorRuralValidatorTest extends IEValidatorTest {

	public IESaoPauloProdutorRuralValidatorTest() {
		super(wrongCheckDigitString, validUnformattedString, validString, validValues);
	}

	private static final String wrongCheckDigitString = "P011004245002";
	private static final String validUnformattedString = "P011004243002";
	private static final String validString = "P-01100424.3/002";
	// TODO adicionar mais IE validos para São Paulo
	private static final String[] validValues = { validString };
	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IESaoPauloProdutorRuralValidator(messageProducer, isFormatted);
	}
}
