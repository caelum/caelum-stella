package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IERondoniaValidatorCasoUmTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformatted:String = '200400403';
		
		protected static const validUnformattedString:String = '200400401';
		
		private static const validFormattedString:String = '101.62521-3';
		
		private static const validValues:Array = ['101.62521-3', '101.20010-7', '101.91080-5', '101.54055-2',
			'203.01019-7', '403.51417-9', '209.49504-2', '109.47520-3', '401.51033-5', '203.40481-1'];
		
		public function IERondoniaValidatorCasoUmTest() {
			super(wrongCheckDigitUnformatted, validFormattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IERondoniaCasoUmValidator(isFormatted, messageProducer);
		}
	}
}