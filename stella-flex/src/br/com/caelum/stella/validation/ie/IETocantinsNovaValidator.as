package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IETocantinsNovaValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		
		private static const DVX_POSITION:int = 3 + 11;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];
		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador Exemplo valido:
		* 29.040.636-6 29.040.634-0 29.385.524-2 29.032.038-0 A verificar :
		*/
		
		public static const FORMATED:RegExp = /^(29)[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATED:RegExp = /^(29)(\d{3})(\d{3})(\d{1})$/;
		
		public function IETocantinsNovaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
			return DVX_CHECKER.isDVValid(testedValue);
		}
	}
}