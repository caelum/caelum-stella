package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IETocantinsAntigaValidatorTest extends IEValidatorTest {
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador
		* 
		* Exemplo valido : 29010227836
		*/
		
		private static const wrongCheckDigitUnformattedString:String = '29010227830';		
		private static const validUnformattedString:String = '29010227836';		
		private static const validFormattedString:String = '29.01.022.783-6';		
		private static const validValues:Array = [validFormattedString];
		
		public function IETocantinsAntigaValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}

		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IETocantinsAntigaValidator(isFormatted, messageProducer);
		}
	}
}