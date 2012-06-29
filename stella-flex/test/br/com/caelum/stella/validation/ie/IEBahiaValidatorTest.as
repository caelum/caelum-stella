package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IEBahiaValidatorTest extends IEValidatorTest {
		
		/*
		* 612345-57
		* 
		* 123456-63
		*/
		private static const wrongCheckDigitUnformattedNewString:String = '61234559';		
		private static const validUnformattedNewString:String = '61234557';		
		private static const validFormattedNewString:String = '612345-57';		
		private static const validValues:Array = [validFormattedNewString, '123456-63'];
		
		public function IEBahiaValidatorTest() {
			super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEBahiaValidator(isFormatted, messageProducer);
		}

	}
}