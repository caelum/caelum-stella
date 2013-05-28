package br.com.caelum.stella
{
	import br.com.caelum.stella.validation.ie.IEErrors;

	public class MapMessageProducer implements MessageProducer {
		
		private var map:Object = {};
		
		public function registerErrorMessage(key:String, message:String):void {
			map[key] = message;
		}
		
		public function getMessage(error:String):ValidationMessage {
			return new SimpleValidationMessage(map[error] || error);
		}
	}
}