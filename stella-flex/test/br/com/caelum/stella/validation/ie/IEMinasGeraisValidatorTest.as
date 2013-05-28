package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IEMinasGeraisValidatorTest extends IEValidatorTest {
		
		private static const wrongFirstCheckDigitUnformattedString:String = '0623079040045';
		private static const wrongSecondCheckDigitUnformattedString:String = '0623079040085';
		private static const validUnformattedString:String = '0623079040081';
		private static const validFormattedString:String = '062.307.904/0081';
		//TODO adicionar mais exemplo de IE validos
		private static const validValues:Array = ['062.307.904/0081'];
		
		public function IEMinasGeraisValidatorTest() {
			super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		[Test]
		public function shouldNotValidateIEWithSecondCheckDigitWrong():void {
			_messageProducer.expects('getMessage').times(1).withArg(IEErrors.INVALID_CHECK_DIGITS);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			try {
				validator.assertValid(wrongFirstCheckDigitUnformattedString);
				fail();
			} catch(e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEMinasGeraisValidator(isFormatted, messageProducer);
		}
	}
}