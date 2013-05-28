package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IEPernambucoAntigaValidator extends AbstractIEValidator {
		
		// Exemplo 18.1.001.0000004-9
		
		// UF Tam Fat f Cálculo DVX
		// PE 14 1 E 11 P7
		
		// VALORES POSSÍVEIS PARA DÍGITOS
		// =1 =8 1/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9
		
		// DVX
		private static const MOD:int = 11;		
		private static const FATOR:int = 1;
		
		private static const DVX_POSITION:int = 14;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P7;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(FATOR, rotinas, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);		
		
		public static const FORMATTED:RegExp = /^([1][8])[.]([1-9])[.](\d{3})[.](\d{7})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^([1][8])([1-9])(\d{3})(\d{7})(\d{1})$/;
		
		public function IEPernambucoAntigaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
				
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = value;
			return DVX_CHECKER.isDVValid(testedValue);
		}
	}
}