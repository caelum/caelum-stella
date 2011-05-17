package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public class IECearaValidatorTest extends IEValidatorTest {

	/*
	 * Formato: 8 dígitos+1 dígito verificador
	 * 
	 * Exemplo: CGF número 06.000.001-5 Exemplo Formatado: 06.998.161-2
	 */

	private static final String wrongCheckDigitUnformattedString = "060000010";

	private static final String validUnformattedString = "060000015";

	private static final String validFormattedString = "06.000.001-5";
	private static final String[] validValues = { "06.998.161-2", "06.864.509-0", "06.031.909-7" };

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IECearaValidator(messageProducer, isFormatted);
	}
}
