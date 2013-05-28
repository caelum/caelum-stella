package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IERoraimaValidator extends AbstractIEValidator {
		
		private static const MOD:int = 9;		
		// TAMANHO = 9
		private static const MISSING_LEFT_SIDE_ZEROS:String = '00000';		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P5;		
		private static const ROTINAS:Array = [IERotinas.D, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, ROTINAS, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);
		
		public static const FORMATTED:RegExp = /^([2][4])(\d{6})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^([2][4])(\d{6})(\d{1})$/;
		
		private const validadorDeDV:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		public function IERoraimaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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
			return this.validadorDeDV.isDVValid(testedValue);
		}
	}
}