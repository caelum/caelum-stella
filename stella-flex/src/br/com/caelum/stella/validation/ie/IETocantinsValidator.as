package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.SimpleMessageProducer;
	import br.com.caelum.stella.ValidationMessage;
	import br.com.caelum.stella.validation.LogicOrComposedValidator;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IETocantinsValidator implements StellaValidator {
		
		private var  _baseValidator:LogicOrComposedValidator;
		
		public function IETocantinsValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			messageProducer = messageProducer || new SimpleMessageProducer();
			
			var validatorClasses:Array = [IETocantinsNovaValidator, IETocantinsAntigaValidator];
			this._baseValidator = new LogicOrComposedValidator(isFormatted, messageProducer, validatorClasses);
		}
		
		public function assertValid(value:Object):void {
			if (value != null) {
				_baseValidator.assertValid(value);
			}
		}
		
		public function invalidMessagesFor(value:Object):Vector.<ValidationMessage> {
			var result:Vector.<ValidationMessage>;
			if (value != null) {
				result = _baseValidator.invalidMessagesFor(value);
			} else {
				result = new Vector.<ValidationMessage>();
			}
			return result;
		}
		
		public function isEligible(value:Object):Boolean {
			return _baseValidator.isEligible(value);
		}
	}
}