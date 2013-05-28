package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IEParanaValidatorTest extends IEValidatorTest {		
		
		private static const wrongFirstCheckDigitUnformattedString:String = '1234567860';
		private static const wrongSecondCheckDigitUnformattedString:String = '1234567859';
		private static const validUnformattedString:String = '1234567850';
		private static const validFormattedString:String = '099.00004-09';
		private static const validValues:Array = ['099.00004-09', '123.45678-50', '826.01749-09', '902.33203-01',
			'738.00291-16', '738.00294-69', '738.00302-03', '738.00313-66', '738.00338-14', '738.00348-96'];
		
		public function IEParanaValidatorTest() {
			super(wrongFirstCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
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
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEParanaValidator(isFormatted, messageProducer);
		}
	}
}