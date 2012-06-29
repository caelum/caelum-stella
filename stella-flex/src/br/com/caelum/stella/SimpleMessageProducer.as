package br.com.caelum.stella
{
	
	public class SimpleMessageProducer implements MessageProducer {
		
		public function SimpleMessageProducer() {
		}
		
		public function getMessage(error:String):ValidationMessage {
			var key:String = 'InvalidValue' + '.' + error;
			var message:String = key.replace(/[.]/, ' : ').replace(/_/g, ' ');
			return new SimpleValidationMessage(message);
		}
	}
}