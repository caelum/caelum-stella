package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IERondoniaValidatorCasoDoisTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformatted:String = '00000001721489';
		
		protected static const validUnformattedString:String = '00000001721488';
		
		private static const validFormattedString:String = '0000000172159-3';
		
		private static const validValues:Array = ['0000000172159-3', '0000000172158-5', '0000000172157-7',
			'0000000172109-7', '0000000172156-9', '0000000172154-2', '0000000172155-1', '0000000172153-4',
			'0000000172152-6', '0000000172151-8', '0000000172128-3', '0000000172126-7', '0000000172150-0',
			'0000000172149-6', '0000000172148-8', '0000000172147-0', '0000000172146-1', '0000000172145-3',
			'0000000058712-5', '0000000172131-3', '0000000043700-0', '0000000050046-1', '0000000058712-5',
			'0000000172131-3', '0000000172144-5', '0000000172143-7'];
		
		public function IERondoniaValidatorCasoDoisTest() {
			super(wrongCheckDigitUnformatted, validUnformattedString, validFormattedString, validValues);
		}		
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IERondoniaCasoDoisValidator(isFormatted, messageProducer);
		}
	}	
}