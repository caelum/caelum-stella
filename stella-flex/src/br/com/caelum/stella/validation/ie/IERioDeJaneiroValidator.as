package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IERioDeJaneiroValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		
		// TAMANHO = 8;
		private static const MISSING_LEFT_SIDE_ZEROS:String = '000000';		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 8;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P8;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		public static const FORMATTED:RegExp = /^([1789]\d{1})[.](\d{3})[.](\d{3})$/;		
		public static const UNFORMATTED:RegExp = /^([1789]\d{1})(\d{3})(\d{3})$/;
		
		public function IERioDeJaneiroValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
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