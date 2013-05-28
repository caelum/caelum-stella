package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IEPernambucoNovaValidator extends AbstractIEValidator {
		
		private static const DVX_MOD:int = 11;		
		private static const DVY_MOD:int = 11;
		
		// TAMANHO = 9;
		private static const MISSING_ZEROS:String = '00000';
		
		private static const DVX_POSITION:int = MISSING_ZEROS.length + 8;		
		private static const DVY_POSITION:int = MISSING_ZEROS.length + 9;
		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P2;		
		private static const DVY_MULTIPLIERS:Array = IEConstraints.P13;
		
		private static const DVX_ROTINAS:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVY_ROTINAS:Array = [IERotinas.E, IERotinas.POS_IE];
		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, DVX_ROTINAS, DVX_MOD,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVY_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, DVY_ROTINAS, DVY_MOD,
			DVY_MULTIPLIERS, DVY_POSITION);
		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);		
		private static const DVY_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVY_INFO);
		
		// 0321418-40
		public static const FORMATTED:RegExp = /^(\d{7})[-](\d{2})$/;
		public static const UNFORMATTED:RegExp = /^(\d{7})(\d{2})$/;
		
		private static const REPLACEMENT:String = MISSING_ZEROS + '$1$2';
		
		public function IEPernambucoNovaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String;
			
			if (UNFORMATTED.test(value)) {
				testedValue = value.replace(UNFORMATTED, REPLACEMENT);
			}
			var DVXisValid:Boolean = DVX_CHECKER.isDVValid(testedValue);
			var DVYisValid:Boolean = DVY_CHECKER.isDVValid(testedValue);
			return (DVXisValid) && (DVYisValid);
		}
	}
}