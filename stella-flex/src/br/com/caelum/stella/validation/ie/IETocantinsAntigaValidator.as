package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IETocantinsAntigaValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;		
		private static const DVX_POSITION:int = 3 + 11;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P6;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];
		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);
		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador
		* 
		* Exemplo valido : 29010227836
		*/		
		public static const FORMATTED:RegExp = /^(29)[.]((01)|(02)|(03)|(99))[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^(29)((01)|(02)|(03)|(99))(\d{3})(\d{3})(\d{1})$/;
		
		public function IETocantinsAntigaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
			return DVX_CHECKER.isDVValid(testedValue);
		}
	}
}