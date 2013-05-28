package br.com.caelum.stella
{
	public interface MessageProducer {
		
		function getMessage(invalidValue:String):ValidationMessage;
	}
}