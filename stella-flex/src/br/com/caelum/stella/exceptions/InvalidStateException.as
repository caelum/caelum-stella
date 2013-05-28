package br.com.caelum.stella.exceptions
{
	import br.com.caelum.stella.ValidationMessage;

	public class InvalidStateException extends Error {
		
		private var _invalidMessages:Vector.<ValidationMessage>;
		
		/*
		 * message pode ser ValidationMessage ou
		 * um Vector.<ValidationMessage>
		 */
		public function InvalidStateException(message:*) {
			super();
			
			if (message is Vector.<ValidationMessage>) {
				_invalidMessages = message;
			} else {
				_invalidMessages = new Vector.<ValidationMessage>();
				_invalidMessages.push(ValidationMessage(message));
			}
		}		

		public function get invalidMessages():Vector.<ValidationMessage> {
			return _invalidMessages;
		}
	}
}