package br.com.caelum.stella.validation
{
	import br.com.caelum.stella.ValidationMessage;

	public interface StellaValidator {
		
		function assertValid(object:Object):void;
		
		function invalidMessagesFor(object:Object):Vector.<ValidationMessage>;
		
		function isEligible(value:Object):Boolean;
	}
}