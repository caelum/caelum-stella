package br.com.caelum.stella.validation
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.ValidationMessage;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.ie.IEErrors;

	public class LogicOrComposedValidator implements StellaValidator {
		
		public var validators:Vector.<StellaValidator>;
		private var _messageProducer:MessageProducer;
		
		public function LogicOrComposedValidator(isFormatted:Boolean,
			messageProducer:MessageProducer, validatorClasses:Array) {
			
			_messageProducer = messageProducer;
			this.validators = new Vector.<StellaValidator>();
			
			for each (var clazz:Class in validatorClasses) {
				this.validators.push(new clazz(isFormatted, _messageProducer));
			}
		}
		
		public function assertValid(value:Object):void {
			var lastException:Error = null;
			var isValid:Boolean = false;
			
			for each (var v:StellaValidator in validators) {
				if (v.isEligible(value)) {
					try {
						v.assertValid(value);
						isValid = true;
						break;
					} catch (e:InvalidStateException) {
						lastException = e;
					}	
				}					
			}			
			if (!isValid) {
				if (lastException != null) {
					throw lastException;
				} else {
					throw new InvalidStateException(_messageProducer.getMessage(IEErrors.INVALID_FORMAT));
				}
			}
		}
		
		public function invalidMessagesFor(value:Object):Vector.<ValidationMessage> {
			var result:Vector.<ValidationMessage> = null;
			
			for each (var v:StellaValidator in validators) {
				if (v.isEligible(value)) {
					var invalidMessages:Vector.<ValidationMessage> = v.invalidMessagesFor(value);
					result = invalidMessages;
					if (invalidMessages.length === 0) {
						break;
					}
				}
			}
			if (result == null) {
				result = new Vector.<ValidationMessage>();
				result.push(_messageProducer.getMessage(IEErrors.INVALID_FORMAT));
			}
			return result;
		}
		
		public function isEligible(object:Object):Boolean {
			var result:Boolean = false;
			
			for each (var v:StellaValidator in validators) {
				if (v.isEligible(object)) {
					result = true;
					break;
				}
			}
			return result;
		}
	}
}