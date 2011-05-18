package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

@RunWith(value = Suite.class)
@SuiteClasses(value = { IETocantinsValidatorTest.IETocantinsAntiga.class,
		IETocantinsValidatorTest.IETocantinsNova.class })
public class IETocantinsValidatorTest {

	/*
	 * Este teste é um dos mais complexos. Este IETocantinsValidatorTest suporta
	 * o equivalente ao IETocantinsNovaValidator E IETocantinsAntigaValidator
	 * utilizando o LogicOrComposedValidator internamente.
	 * 
	 * O que eu fiz foi criar 2 classes internas que copiam os exemplos do
	 * IETocantinsNovaValidatorTest e IETocantinsAntigaValidatorTest e ambos
	 * usam o IETocantinsValidator. Esta abordagem não funcionou para 3 métodos
	 * de teste genérico que foram sbreescritos:
	 * shouldNotValidateIEWithLessDigitsThanAllowed e
	 * shouldNotValidateIEWithMoreDigitsThanAlowed que não fazem sentido pois os
	 * limites de caracter são muito distantes e o terceiro método
	 * shouldNotValidateIEWithInvalidCharacter que ao inves de lançar
	 * IEError.INVALID_DIGITS lança IEError.INVALID_FORMAT por causa da
	 * utilização do LogicOrComposedValidator
	 */

	/*
	 * Formato: 8 dígitos (empresa)+1 dígito verificador
	 * 
	 * Exemplo valido: 29.040.636-6 29.040.634-0 29.385.524-2 29.032.038-0
	 * 
	 * Exemplo antigo valido : 29010227836
	 */

	public static Validator<String> newValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IETocantinsValidator(messageProducer, isFormatted);
	}

	public static class IETocantinsAntiga extends IEValidatorTest {

		public IETocantinsAntiga() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformattedString = "29010227830";

		private static final String validUnformattedString = "29010227836";

		private static final String validFormattedString = "29.01.022.783-6";

		private static final String[] validValues = { validFormattedString };

		@Override
		protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
			return newValidator(messageProducer, isFormatted);
		}

		@Override
		public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		}

		@Override
		public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		}

		@Override
		public void shouldNotValidateIEWithInvalidCharacter() {
			Validator<String> validator = getValidator(messageProducer, false);
			try {
				validator.assertValid(validUnformattedString.replaceFirst(".", "&"));
				fail();
			} catch (InvalidStateException e) {
				assertTrue(e.getInvalidMessages().size() == 1);
			}

			verify(messageProducer, times(1)).getMessage(IEError.INVALID_FORMAT);
		}
	}

	public static class IETocantinsNova extends IEValidatorTest {

		public IETocantinsNova() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformattedString = "290406360";

		private static final String validUnformattedString = "290406366";

		private static final String validFormattedString = "29.040.636-6";

		private static final String[] validValues = { validFormattedString, "29.040.634-0", "29.385.524-2",
				"29.032.038-0" };

		@Override
		protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
			return newValidator(messageProducer, isFormatted);
		}

		@Override
		public void shouldNotValidateIEWithLessDigitsThanAllowed() {
		}

		@Override
		public void shouldNotValidateIEWithMoreDigitsThanAlowed() {
		}

		@Override
		public void shouldNotValidateIEWithInvalidCharacter() {
			Validator<String> validator = getValidator(messageProducer, false);
			try {
				validator.assertValid(validUnformattedString.replaceFirst(".", "&"));
				fail();
			} catch (InvalidStateException e) {
				assertTrue(e.getInvalidMessages().size() == 1);
			}

			verify(messageProducer, times(1)).getMessage(IEError.INVALID_FORMAT);
		}
	}

}
