package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IESantaCatarinaValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitString:String = '251040858';
		private static const validUnformattedString:String = '251040852';
		private static const validString:String = '251.040.852';
		// TODO adicionar mais IE validos para SantaCatarina
		private static const validValues:Array = [validString];
		
		public function IESantaCatarinaValidatorTest() {
			super(wrongCheckDigitString, validUnformattedString, validString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IESantaCatarinaValidator(isFormatted, messageProducer);
		}
	}
}