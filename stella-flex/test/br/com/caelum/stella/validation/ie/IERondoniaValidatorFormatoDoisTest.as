package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	/*
	* Teste de valores do caso dois contra IERondoniaValidator
	* Verificar IERondoniaValidatorFormatoUmTest para valores do caso um.
	*/
	public class IERondoniaValidatorFormatoDoisTest extends IERondoniaValidatorCasoDoisTest {
		
		public function IERondoniaValidatorFormatoDoisTest() {
		}
		
		override public function shouldNotValidateIEWithLessDigitsThanAllowed():void {
		}
		
		override public function shouldNotValidateIEWithMoreDigitsThanAlowed():void {
		}
		
		override public function shouldNotValidateIEWithInvalidCharacter():void {
			_messageProducer.expects('getMessage').times(1).withArg(IEErrors.INVALID_FORMAT);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			try {
				validator.assertValid(validUnformattedString.replace(/./, '&'));
				fail();
			} catch (e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IERondoniaValidator(isFormatted, messageProducer);
		}
	}
}