package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IESaoPauloProdutorRuralValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitString:String = 'P011004245002';
		private static const validUnformattedString:String = 'P011004243002';
		private static const validString:String = 'P-01100424.3/002';
		// TODO adicionar mais IE validos para São Paulo
		private static const validValues:Array = [validString];
		
		public function IESaoPauloProdutorRuralValidatorTest() {
			super(wrongCheckDigitString, validUnformattedString, validString, validValues);
		}		
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IESaoPauloProdutorRuralValidator(isFormatted, messageProducer);
		}
		
	}
}