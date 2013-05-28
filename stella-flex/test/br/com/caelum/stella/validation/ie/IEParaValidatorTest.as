package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IEParaValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '159999999';		
		private static const validUnformattedString:String = '159999995';		
		private static const validFormattedString:String = '15.999.999-5';		
		private static const validValues:Array = [validFormattedString, '15.229.851-7', '15.133.081-6', '15.143.772-6',
			'15.191.809-0', '15.133.081-6', '15.105.561-0', '15.069.510-1', '15.002.934-9', '15.133.041-7'];
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador Exemplo: 15.999.999-5
		*/		
		public function IEParaValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEParaValidator(isFormatted, messageProducer);
		}
	}
}