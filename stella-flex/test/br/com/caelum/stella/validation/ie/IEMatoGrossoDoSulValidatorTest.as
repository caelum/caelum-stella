package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IEMatoGrossoDoSulValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '283037591';
		
		private static const validUnformattedString:String = '283037598';
		
		private static const validFormattedString:String = '28.303.759-8';
		private static const validValues:Array = [validFormattedString, '28.322.235-2', '28.301.273-0', '28.288.890-0',
			'28.226.590-2', '28.296.665-0', '28.303.740-7', '28.306.701-2', '28.071.810-1', '28.311.591-2',
			'28.098.983-0', '28.316.487-5'];
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador
		* 
		* Exemplo: 28.303.759-8
		*/		
		public function IEMatoGrossoDoSulValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEMatoGrossoDoSulValidator(isFormatted, messageProducer);
		}
	}
}