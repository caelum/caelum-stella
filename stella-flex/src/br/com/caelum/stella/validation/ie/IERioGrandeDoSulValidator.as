package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IERioGrandeDoSulValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;		
		// TAMANHO = 10;
		private static const MISSING_LEFT_SIDE_ZEROS:String = '0000';		
		private static const DVX_POSITION:int = MISSING_LEFT_SIDE_ZEROS.length + 10;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		public static const FORMATTED:RegExp = /^([0-4]\d{2})[\/](\d{6})(\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^([0-4]\d{2})(\d{6})(\d{1})$/;
		
		public function IERioGrandeDoSulValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getInvalidValues(ie:String):Vector.<String> {
			var errors:Vector.<String> = new Vector.<String>();
			if (ie != null) {
				var unformattedIE:String = checkForCorrectFormat(ie, errors);
				if (errors.length === 0) {
					if (!hasValidCheckDigits(unformattedIE)) {
						errors.push(IEErrors.INVALID_CHECK_DIGITS);
					}
					if (!hasValidMunicipality(unformattedIE)) {
						errors.push(IEErrors.INVALID_MUNICIPALITY);
					}
				}
			}
			return errors;
		}
		
		protected function hasValidMunicipality(unformattedIE:String):Boolean {
			var municipality:String;
			if (UNFORMATTED.test(unformattedIE)) {
				municipality = unformattedIE.replace(UNFORMATTED, '$1');
			}
			var municipalityInt:int = parseInt(municipality);
			var result:Boolean = municipalityInt > 0 && municipalityInt <= 467;
			return result;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var testedValue:String = MISSING_LEFT_SIDE_ZEROS + value;
			return DVX_CHECKER.isDVValid(testedValue);
		}
	}
}