package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IERioGrandeDoNorteValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;		
		private static const DVX_POSITION:int = 5 + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P11;		
		private static const rotinas:Array = [IERotinas.B, IERotinas.D, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		/*
		* 20.040.040-1(9 dígitos) ou 20.0.040.040-0(10 dígitos) (as duas são
		* válidas)(ampliação do número de dígitos) (Os primeiros dois dígitos são
		* sempre 20)
		*/		
		public static const FORMATTED:RegExp = /^([2][0])[.](\d[.])?(\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^([2][0])(\d{6,7})(\d{1})$/;
		
		public function IERioGrandeDoNorteValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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