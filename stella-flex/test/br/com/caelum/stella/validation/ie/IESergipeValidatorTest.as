package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IESergipeValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '271234564';
		private static const validUnformattedString:String = '271234563';
		private static const validString:String = '27123456-3';
		// TODO adicionar mais IE validos para Sergipe
		private static const validValues:Array = [validString];
		
		public function IESergipeValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IESergipeValidator(isFormatted, messageProducer);
		}
	}
}