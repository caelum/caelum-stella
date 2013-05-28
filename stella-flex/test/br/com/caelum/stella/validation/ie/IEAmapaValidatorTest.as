package br.com.caelum.stella.validation.ie {
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;
	
	public class IEAmapaValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '030123450';		
		private static const validUnformattedString:String = '030123459';		
		private static const validFormattedString:String = '03.012.345-9';		
		private static const validValues:Array = [validFormattedString];
		
		public function IEAmapaValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}		
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEAmapaValidator(isFormatted, messageProducer);
		}
	}
}