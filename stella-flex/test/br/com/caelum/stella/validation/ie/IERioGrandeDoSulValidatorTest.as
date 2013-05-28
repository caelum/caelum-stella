package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IERioGrandeDoSulValidatorTest extends IEValidatorTest {
		
		private static const validFormattedString:String = '224/3658792';
		private static const validUnformattedString:String = '2243658792';
		private static const wrongCheckDigitUnformattedString:String = '2243658791';
		private static const validValues:Array = [validFormattedString];
		
		public function IERioGrandeDoSulValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		[Test]
		public function shouldNotValidateIEWithInvalidMunicipalityWithZeros():void {
			_messageProducer.expects('getMessage').withArg(IEErrors.INVALID_MUNICIPALITY).times(2);
			_messageProducer.expects('getMessage').withArg(IEErrors.INVALID_CHECK_DIGITS);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			// VALID IE = 224/3658792
			var value1:String = '0003658791';
			try {
				validator.assertValid(value1);
				fail();
			} catch (e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
									
			var value2:String = '0003658792';
			try {
				validator.assertValid(value2);
				fail();
			} catch (e:InvalidStateException) {
				assertEquals(2, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IERioGrandeDoSulValidator(isFormatted, messageProducer);
		}

	}
}