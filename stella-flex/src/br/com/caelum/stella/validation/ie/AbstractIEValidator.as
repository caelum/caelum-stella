package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.ValidationMessage;
	import br.com.caelum.stella.validation.BaseValidator;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import flash.events.EventDispatcher;

	public class AbstractIEValidator extends EventDispatcher implements StellaValidator {
		
		private var _isFormatted:Boolean;
		private var _baseValidator:BaseValidator;
		
		public function AbstractIEValidator(isFormatted:Boolean, messageProducer:MessageProducer) {
			this._isFormatted = isFormatted;
			_baseValidator = new BaseValidator(messageProducer);
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
		
		protected function checkForCorrectFormat(ie:String, errors:Vector.<String>):String {
			var unformattedIE:String;
			var pattern:RegExp;
			
			if (_isFormatted) {
				pattern = getFormattedPattern();
				if (!pattern.test(ie)) {
					errors.push(IEErrors.INVALID_FORMAT);
				}
				unformattedIE = ie.replace(/\D/g, '');
			} else {
				pattern = getUnformattedPattern();
				if (!pattern.test(ie)) {
					errors.push(IEErrors.INVALID_DIGITS);
				}
				unformattedIE = ie;
			}
			return unformattedIE;
		}
		
		public function invalidMessagesFor(ie:Object):Vector.<ValidationMessage> {
			return _baseValidator.generateValidationMessages(getInvalidValues(ie as String)); //TODO esquema do tipo
		}
		
		public function assertValid(object:Object):void {
			return _baseValidator.assertValid(getInvalidValues(object as String)); //TODO esquema do tipo
		}
		
		public function isEligible(value:Object):Boolean {
			var result:Boolean;
			var pattern:RegExp;
			
			if (_isFormatted) {
				pattern = getFormattedPattern();
				result = pattern.test(String(value));
			} else {
				pattern = getUnformattedPattern();
				result = pattern.test(String(value));
			}
			
			return result;
		}
		
		protected function hasValidCheckDigits(value:String):Boolean {
			throw new Error('override IEAbstractValidator.hasValidCheckDigits');
		}
		
		protected function getFormattedPattern():RegExp {
			throw new Error('override IEAbstractValidator.getFormattedPattern');
		}
		
		protected function getUnformattedPattern():RegExp {
			throw new Error('override IEAbstractValidator.getUnformattedPattern');
		}
	}
}