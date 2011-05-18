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
@SuiteClasses(value = { IEPernambucoValidatorTest.IEPernambucoValidatorAntigoFormato.class,
		IEPernambucoValidatorTest.IEPernambucoValidatorNovoFormato.class })
public class IEPernambucoValidatorTest {
	
	/*
	 * Este teste é um dos mais complexos. Este IEPernambucoValidator suporta o equivalente ao
	 * IEPernambucoAntigaValidator E IEPernambucoNovaValidator utilizando o LogicOrComposedValidator
	 * internamente.
	 * 
	 * O que eu fiz foi criar 2 classes internas que copiam os exemplos do IEPernambucoAntigaValidatorTest
	 * e IEPernambucoNovaValidatorTest e ambos usam o IEPernambucoValidator.
	 * Esta abordagem não funcionou para 3 métodos de teste genérico que foram sbreescritos:
	 * shouldNotValidateIEWithLessDigitsThanAllowed e shouldNotValidateIEWithMoreDigitsThanAlowed 
	 * que não fazem sentido pois os limites de caracter são muito distantes
	 * e o terceiro método shouldNotValidateIEWithInvalidCharacter que ao inves de lançar
	 * IEError.INVALID_DIGITS lança IEError.INVALID_FORMAT por causa da utilização do LogicOrComposedValidator
	 * 
	 */
	
	

	public static IEPernambucoValidator newValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IEPernambucoValidator(messageProducer, isFormatted);
	}

	public static class IEPernambucoValidatorAntigoFormato extends IEValidatorTest {

		/*
		 * IE validas
		 * 
		 * 18.1.001.0000004-9 18100100000049
		 */

		public IEPernambucoValidatorAntigoFormato() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformattedString = "18100100000048";

		private static final String validUnformattedString = "18100100000049";

		private static final String validFormattedString = "18.1.001.0000004-9";

		// TODO Adicionar mais IE validas
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

	public static class IEPernambucoValidatorNovoFormato extends IEValidatorTest {

		/*
		 * IE validas
		 * 
		 * 0321418-40 032141840
		 */

		public IEPernambucoValidatorNovoFormato() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformattedString = "032141849";

		private static final String validUnformattedString = "032141840";

		private static final String validFormattedString = "0321418-40";

		// TODO Adicionar mais IE validas
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

}
