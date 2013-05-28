package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IERioDeJaneiroValidatorTest extends IEValidatorTest {
		
		private static const validFormattedString:String = '78.045.302';
		private static const validUnformattedString:String = '78045302';
		private static const wrongCheckDigitUnformattedString:String = '78045304';
		private static const validValues:Array = [validFormattedString];
		
		public function IERioDeJaneiroValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}		
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IERioDeJaneiroValidator(isFormatted, messageProducer);
		}
	}
}