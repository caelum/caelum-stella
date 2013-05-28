package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;
	
	public class IEPernambucoAntigaValidatorTest extends IEValidatorTest {
		
		/*
		* IE validas
		* 
		* 18.1.001.0000004-9 18100100000049
		*/
		private static const wrongCheckDigitUnformattedString:String = '18100100000048';		
		protected static const validUnformattedString:String = '18100100000049';		
		private static const validFormattedString:String = '18.1.001.0000004-9';		
		// TODO Adicionar mais IE validas
		private static const validValues:Array = [validFormattedString];
		
		public function IEPernambucoAntigaValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEPernambucoAntigaValidator(isFormatted, messageProducer);
		}
	}
}