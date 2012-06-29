package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.ValidationMessage;
	import br.com.caelum.stella.validation.BaseValidator;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.StellaValidator;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IESaoPauloProdutorRuralValidator implements StellaValidator {
		
		private static const MOD:int = 11;
		
		// TAMANHO = 13;
		private static const MISSING_LEFT_SIDE_ZEROS:String = "00";
		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P12;
		
		private static const rotinas:Array = [IERotinas.D, IERotinas.POS_IE];
		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);
		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		private var isFormatted:Boolean;
		
		public static const FORMATTED:RegExp = /^P-(\d{8})[.](\d{1})[\/](\d{3})$/;		
		public static const UNFORMATTED:RegExp = /^P(\d{8})(\d{1})(\d{3})$/;
		
		private var _baseValidator:BaseValidator;
		
		public function IESaoPauloProdutorRuralValidator(isFormatted:Boolean, messageProducer:MessageProducer) {
			_baseValidator = new BaseValidator(messageProducer);
			this.isFormatted = isFormatted;
		}
		
		protected function getInvalidValues(ie:String):Vector.<String> {
			var errors:Vector.<String> = new Vector.<String>();
			if (ie != null) {
				var unformattedIE:String = checkForCorrectFormat(ie, errors);
				if (errors.length === 0) {
					if (!hasValidCheckDigits(unformattedIE)) {
						errors.push(IEErrors.INVALID_CHECK_DIGITS);
					}
				}
			}
			return errors;
		}
		
		private function checkForCorrectFormat(ie:String, errors:Vector.<String>):String {
			var unformattedIE:String;
			
			if (isFormatted) {
				if (!FORMATTED.test(ie)) {
					errors.push(IEErrors.INVALID_FORMAT);
				}
				unformattedIE = ie.replace(/\D/g, '');
			} else {
				if (!UNFORMATTED.test(ie)) {
					errors.push(IEErrors.INVALID_DIGITS);
				}
				unformattedIE = ie.replace(/\D/g, '');
			}
			return unformattedIE;
		}

		private function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = MISSING_LEFT_SIDE_ZEROS + value;
			return (DVX_CHECKER.isDVValid(testedValue));
		}
		
		public function isEligible(value:Object):Boolean {
			var result:Boolean;
			if (isFormatted) {
				result = FORMATTED.test(String(value));
			} else {
				result = UNFORMATTED.test(String(value));
			}
			return result;
		}
		
		public function assertValid(value:Object):void {
			_baseValidator.assertValid(getInvalidValues(value as String)); //TODO esquema do tipo
		}
		
		public function invalidMessagesFor(value:Object):Vector.<ValidationMessage> {
			return _baseValidator.generateValidationMessages(getInvalidValues(value as String)); //TODO esquema do tipo
		}
	}
}