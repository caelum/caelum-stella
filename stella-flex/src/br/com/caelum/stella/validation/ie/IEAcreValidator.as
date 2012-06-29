package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;
	
	public class IEAcreValidator extends AbstractIEValidator {
		
		public static const FORMATTED:RegExp = /^(01)[.](\d{3})[.](\d{3})[\/](\d{3})[-](\d{2})$/;
		public static const UNFORMATTED:RegExp = /^(01)(\d{3})(\d{3})(\d{3})(\d{2})$/;
		
		private static const MOD:int = 11;
		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];
				
		private static const DVX_POSITION:int = 1 + 13;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		private static const DVY_POSITION:int = 1 + 12;
		private static const DVY_MULTIPLIERS:Array = IEConstraints.P2;		
		private static const DVY_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(
			0, rotinas, MOD, DVY_MULTIPLIERS, DVY_POSITION);		
		private static const DVY_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVY_INFO);
		
		public function IEAcreValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
			return DVX_CHECKER.isDVValid(testedValue) &&
				DVY_CHECKER.isDVValid(testedValue);
		}
	}
}