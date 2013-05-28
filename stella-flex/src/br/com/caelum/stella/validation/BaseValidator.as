package br.com.caelum.stella.validation
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.SimpleMessageProducer;
	import br.com.caelum.stella.ValidationMessage;
	import br.com.caelum.stella.exceptions.InvalidStateException;

	public class BaseValidator {
		
		private var _messageProducer:MessageProducer;
		
		public function BaseValidator(messageProducer:MessageProducer = null) {
			if (messageProducer == null) {
				messageProducer = new SimpleMessageProducer();
			}
			_messageProducer = messageProducer;
		}
		
		public function generateValidationMessages(invalidValues:Vector.<String>):Vector.<ValidationMessage> {
			var messages:Vector.<ValidationMessage> = new Vector.<ValidationMessage>();
			for each (var invalidValue:String in invalidValues) {
				var message:ValidationMessage = _messageProducer.getMessage(invalidValue);
				messages.push(message);
			}
			return messages;
		}
		
		public function assertValid(invalidValues:Vector.<String>):void {
			if (invalidValues.length > 0) {
				throw new InvalidStateException(generateValidationMessages(invalidValues));
			}
		}
	}
}