package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IEDistritoFederalValidatorTest extends IEValidatorTest {
		
		private static const wrongFirstCheckDigitUnformattedString:String = '0740873800240';		
		private static const wrongSecondCheckDigitUnformattedString:String = '0740873800240';		
		private static const validUnformattedString:String = '0740873800250';		
		private static const validFormattedString:String = '07.408.738/002-50';		
		private static const validValues:Array = [validFormattedString, '07.343.623/001-77', '07.451.530/001-68',
			'07.389.634/001-01', '07.336.802/001-60', '07.346.779/001-46', '07.548.137/001-52'];
		
		public function IEDistritoFederalValidatorTest() {
			super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEDistritoFederalValidator(isFormatted, messageProducer);
		}
		
		[Test]
		public function shouldNotValidateIEWithSecondCheckDigitWrong():void {
			_messageProducer.expects('getMessage').times(1).withArg(IEErrors.INVALID_CHECK_DIGITS);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			try {
				validator.assertValid(wrongSecondCheckDigitUnformattedString);
				fail();
			} catch (e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
	}
}