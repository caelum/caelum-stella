package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IERondoniaCasoDoisValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		
		// TAMANHO = 14;
		private static const MISSING_LEFT_SIDE_ZEROS:String = "";		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 14;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(1, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		public static const FORMATTED:RegExp = /^(\d{13})[-](\d{1})$/;		
		public static const UNFORMATED:RegExp = /^(\d{13})(\d{1})$/;
		
		public function IERondoniaCasoDoisValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = MISSING_LEFT_SIDE_ZEROS + value;
			return DVX_CHECKER.isDVValid(testedValue);
		}

	}
}