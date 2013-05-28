package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IETocantinsNovaValidatorTest extends IEValidatorTest {
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador
		* 
		* Exemplo valido: 29.040.636-6 29.040.634-0 29.385.524-2 29.032.038-0
		*/
		
		private static const wrongCheckDigitUnformattedString:String = '290406360';		
		private static const validUnformattedString:String = '290406366';		
		private static const validFormattedString:String = '29.040.636-6';		
		private static const validValues:Array = [validFormattedString, '29.040.634-0', '29.385.524-2', '29.032.038-0'];
		
		public function IETocantinsNovaValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IETocantinsNovaValidator(isFormatted, messageProducer);
		}
	}
}