package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IEMaranhaoValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '120000386';		
		private static const validUnformattedString:String = '120000385';		
		private static const validFormattedString:String = '12.000.038-5';		
		private static const validValues:Array = [validFormattedString];
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador
		* 
		* Exemplo:
		*/		
		public function IEMaranhaoValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEMaranhaoValidator(isFormatted, messageProducer);
		}
	}
}