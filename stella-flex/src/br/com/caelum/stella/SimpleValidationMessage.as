package br.com.caelum.stella
{
	public class SimpleValidationMessage implements ValidationMessage {
		
		private var _message:String;
		
		public function SimpleValidationMessage(message:String) {
			_message = message;
		}
		
		public function getMessage():String {
			return _message;
		}
	}
}