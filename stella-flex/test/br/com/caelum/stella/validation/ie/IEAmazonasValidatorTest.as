package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;
	
	public class IEAmazonasValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '041939800';		
		private static const validUnformattedString:String = '041939808';
		private static const validString:String = '04.193.980-8';		
		private static const validValues:Array = ['04.345.678-2',
			'04.193.980-8', '06.200.021-7',	'07.000.507-9'];
		
		public function IEAmazonasValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString,
				validString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEAmazonasValidator(isFormatted, messageProducer);
		}
	}
}