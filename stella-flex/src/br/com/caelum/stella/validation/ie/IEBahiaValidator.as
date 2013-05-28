package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	/**
	 * <p>
	 * Documentação de referência:
	 * </p>
	 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
	 * Fazenda do Estado de São Paulo</a> <a
	 * href="http://www.sintegra.gov.br/Cad_Estados/cad_BA.html">SINTEGRA - ROTEIRO
	 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
	 * 
	 */
	public class IEBahiaValidator extends AbstractIEValidator {		
		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		
		private static const DVX_POSITION:int = 6 + 8;		
		private static const DVY_POSITION:int = 6 + 7;		
		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P2;
		private static const DVY_MULTIPLIERS:Array = IEConstraints.P3;
		
		private static const DVX_INFO_MOD11:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, 11,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_CHECKER_MOD11:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_MOD11);
		
		private static const DVY_INFO_MOD11:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, 11,
			DVY_MULTIPLIERS, DVY_POSITION);		
		private static const DVY_CHECKER_MOD11:ValidadorDeDV = new ValidadorDeDV(DVY_INFO_MOD11);
		
		private static const DVX_INFO_MOD10:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, 10,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_CHECKER_MOD10:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_MOD10);
		
		private static const DVY_INFO_MOD10:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, 10,
			DVY_MULTIPLIERS, DVY_POSITION);
		private static const DVY_CHECKER_MOD10:ValidadorDeDV = new ValidadorDeDV(DVY_INFO_MOD10);
		
		/*
		* 612345-57
		* 
		* 123456-63
		*/
		public static const FORMATTED:RegExp = /^(\d{6})[-](\d{2})$/;
		public static const UNFORMATTED:RegExp = /^(\d{6})(\d{2})$/;
		
		public function IEBahiaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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
			var result:Boolean = false;
			switch (value.charAt(0)) {
				case '6':
				case '7':
				case '9':
					result = DVX_CHECKER_MOD11.isDVValid(testedValue) && DVY_CHECKER_MOD11.isDVValid(testedValue);
					break;
				default:
					result = DVX_CHECKER_MOD10.isDVValid(testedValue) && DVY_CHECKER_MOD10.isDVValid(testedValue);
			}
			return result;
		}
	}
}