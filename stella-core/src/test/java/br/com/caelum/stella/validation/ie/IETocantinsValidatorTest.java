package br.com.caelum.stella.validation.ie;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.Validator;

public class IETocantinsValidatorTest extends IEValidatorTest {

	public IETocantinsValidatorTest() {
		super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformattedString = "290406360";

	private static final String validUnformattedString = "290406366";

	private static final String validFormattedString = "29.040.636-6";

	private static final String[] validValues = { validFormattedString, "29.040.634-0", "29.385.524-2", "29.032.038-0", "29.074.854-2", "29.380.563-6" };
	
	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IETocantinsValidator(messageProducer, isFormatted);
	}
	
	@Test
	public void deveValidarAIESeVierComOsDigitosASeremIgnorados(){
		String ieCompleta = "29023805636";
		Validator<String> validator = getValidator(messageProducer, false);
		List<ValidationMessage> invalidMessages = validator.invalidMessagesFor(ieCompleta);
		Assert.assertEquals(0, invalidMessages.size());
		
		String ieCompletaFormatada = "29 02 380.563-6";
		validator = getValidator(messageProducer, true);
		invalidMessages = validator.invalidMessagesFor(ieCompletaFormatada);
		Assert.assertEquals(0, invalidMessages.size());
		
	}
	
}
