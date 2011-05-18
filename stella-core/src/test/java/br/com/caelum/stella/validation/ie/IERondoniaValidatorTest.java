package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
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
@SuiteClasses(value = { IERondoniaValidatorTest.IERondoniaValidatorFormatoUm.class,
		IERondoniaValidatorTest.IERondoniaValidatorFormatoDois.class })
public class IERondoniaValidatorTest {

	/*
	 * Este teste é um dos mais complexos. Este IERondoniaValidatorTest suporta
	 * o equivalente ao IERondoniaValidatorCasoUmTest E
	 * IERondoniaValidatorCasoDoisTest utilizando o LogicOrComposedValidator
	 * internamente.
	 * 
	 * O que eu fiz foi criar 2 classes internas que copiam os exemplos do
	 * IERondoniaValidatorCasoUmTest e IERondoniaValidatorCasoDoisTest e ambos
	 * usam o IERondoniaValidator. Esta abordagem não funcionou para 3 métodos
	 * de teste genérico que foram sbreescritos:
	 * shouldNotValidateIEWithLessDigitsThanAllowed e
	 * shouldNotValidateIEWithMoreDigitsThanAlowed que não fazem sentido pois os
	 * limites de caracter são muito distantes e o terceiro método
	 * shouldNotValidateIEWithInvalidCharacter que ao inves de lançar
	 * IEError.INVALID_DIGITS lança IEError.INVALID_FORMAT por causa da
	 * utilização do LogicOrComposedValidator
	 */

	public static IERondoniaValidator newValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERondoniaValidator(messageProducer, isFormatted);
	}

	public static class IERondoniaValidatorFormatoUm extends IEValidatorTest {
		public IERondoniaValidatorFormatoUm() {
			super(wrongCheckDigitUnformatted, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformatted = "200400403";

		private static final String validUnformattedString = "200400401";

		private static final String validFormattedString = "101.62521-3";

		private static final String[] validValues = { "101.62521-3", "101.20010-7", "101.91080-5", "101.54055-2",
				"203.01019-7", "403.51417-9", "209.49504-2", "109.47520-3", "401.51033-5", "203.40481-1" };

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
			MessageProducer messageProducer = mock(MessageProducer.class);
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

	public static class IERondoniaValidatorFormatoDois extends IEValidatorTest {

		public IERondoniaValidatorFormatoDois() {
			super(wrongCheckDigitUnformatted, validUnformattedString, validFormattedString, validValues);
		}

		private static final String wrongCheckDigitUnformatted = "00000001721489";

		private static final String validUnformattedString = "00000001721488";

		private static final String validFormattedString = "0000000172159-3";

		private static final String[] validValues = { "0000000172159-3", "0000000172158-5", "0000000172157-7",
				"0000000172109-7", "0000000172156-9", "0000000172154-2", "0000000172155-1", "0000000172153-4",
				"0000000172152-6", "0000000172151-8", "0000000172128-3", "0000000172126-7", "0000000172150-0",
				"0000000172149-6", "0000000172148-8", "0000000172147-0", "0000000172146-1", "0000000172145-3",
				"0000000058712-5", "0000000172131-3", "0000000043700-0", "0000000050046-1", "0000000058712-5",
				"0000000172131-3", "0000000172144-5", "0000000172143-7" };

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
			MessageProducer messageProducer = mock(MessageProducer.class);
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
