package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IESaoPauloComercioIndustriaValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitString:String = '110042490104';
		private static const wrongSecondCheckDigitString:String = '110042490115';
		private static const validUnformattedString:String = '110042490114';
		private static const validString:String = '110.042.490.114';
		
		// TODO adicionar mais IE validos para São Paulo
		private static const validValues:Array = [validString];
		
		public function IESaoPauloComercioIndustriaValidatorTest() {
			super(wrongCheckDigitString, validUnformattedString, validString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IESaoPauloComercioIndustriaValidator(isFormatted, messageProducer);
		}
		
		[Test]
		public function shouldNotValidateIEsWithSecondCheckDigitWrong():void {
			_messageProducer.expects('getMessage').times(1).withArg(IEErrors.INVALID_CHECK_DIGITS);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			try {
				validator.assertValid(wrongSecondCheckDigitString);
				fail();
			} catch (e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
	}
}