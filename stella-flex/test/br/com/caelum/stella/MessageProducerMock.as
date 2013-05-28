package br.com.caelum.stella
{
	import org.mock4as.Mock;

	public class MessageProducerMock extends Mock implements MessageProducer {
		
		public function MessageProducerMock() {
		}
		
		public function getMessage(invalidValue:String):ValidationMessage {
			record('getMessage', invalidValue);
			return expectedReturnFor('getMessage') as ValidationMessage;
		}
	}
}