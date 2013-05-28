package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IESaoPauloComercioIndustriaValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		
		// TAMANHO = 12;
		private static const MISSING_LEFT_SIDE_ZEROS:String = '00';
		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 9;		
		private static const DVY_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 12;
		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P12;		
		private static const DVY_MULTIPLIERS:Array = IEConstraints.P13;
		
		private static const rotinas:Array = [IERotinas.D, IERotinas.POS_IE];
		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVY_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVY_MULTIPLIERS,
			DVY_POSITION);
		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);		
		private static const DVY_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVY_INFO);
		
		public static const FORMATTED:RegExp = /^(\d{3})[.](\d{3})[.](\d{3})[.](\d{3})$/;		
		public static const UNFORMATTED:RegExp = /^(\d{3})(\d{3})(\d{3})(\d{3})$/;
		
		public function IESaoPauloComercioIndustriaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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
			return (DVX_CHECKER.isDVValid(testedValue)) && (DVY_CHECKER.isDVValid(testedValue));
		}

	}
}