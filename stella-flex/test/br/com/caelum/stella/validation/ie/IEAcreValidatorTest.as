package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;
	
	/*
	* Formato Antigo : ???
	* 
	* Formato Novo: 11 dígitos+2 dígitos verificadores
	* 
	* Os primeiros dois dígitos são sempre 01
	* 
	* Exemplo: Inscrição Estadual 01.004.823/001-12
	* 
	* 01.004.141/001-46
	* 
	* 01.001.349/001-77
	*/
	public class IEAcreValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedNewString:String = '0100482300115';
		private static const validUnformattedNewString:String = '0100482300112';
		private static const validFormattedNewString:String = '01.004.823/001-12';
		
		private static const validValues:Array = [validFormattedNewString, 
			'01.004.141/001-46', '01.001.349/001-77', '01.956.867/001-07'];
		
		public function IEAcreValidatorTest() {
			super(wrongCheckDigitUnformattedNewString, validUnformattedNewString, validFormattedNewString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEAcreValidator(isFormatted, messageProducer);
		}
	}
}