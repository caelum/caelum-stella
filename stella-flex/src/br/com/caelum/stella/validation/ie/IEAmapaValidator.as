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
	 * href="http://www.sintegra.gov.br/Cad_Estados/cad_AP.html">SINTEGRA - ROTEIRO
	 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
	 * 
	 */
	public class IEAmapaValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		
		private static const DVX_POSITION:int = 5 + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;
		
		private static const ROTINAS_CASO1:Array = [IERotinas.C, IERotinas.E, IERotinas.POS_IE];		
		private static const ROTINAS_CASO2:Array = ROTINAS_CASO1;		
		private static const ROTINAS_CASO3:Array = [IERotinas.E, IERotinas.POS_IE];
		
		private static const DVX_INFO_CASO1:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, ROTINAS_CASO1, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_INFO_CASO2:DigitoVerificadorInfo = new DigitoVerificadorInfo(1, ROTINAS_CASO2, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_INFO_CASO3:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, ROTINAS_CASO3, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);
		
		private static const DVX_CHECKER_CASO1:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_CASO1);		
		private static const DVX_CHECKER_CASO2:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_CASO2);		
		private static const DVX_CHECKER_CASO3:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_CASO3);
		
		public static const FORMATTED:RegExp = /^(03)[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^(03)(\d{3})(\d{3})(\d{1})$/;
		
		public function IEAmapaValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
		
		override protected function hasValidCheckDigits(value:String):Boolean {
			var ie:int = parseInt(value) / 10;
			var result:Boolean;
			/*
			* http://www.sintegra.gov.br/Cad_Estados/cad_AP.html
			* 
			* De 03000001X a 03017000X => CASO 1
			* 
			* De 03017001X a 03019022X => CASO 2
			* 
			* De 03019023X em diante => CASO 3
			*/
			var testedValue:String = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
			var validadorDeDV:ValidadorDeDV = null;
			if ((3000001 <= ie) && (ie <= 3017000)) {
				validadorDeDV = DVX_CHECKER_CASO1;
			} else if ((3017001 <= ie) && (ie <= 3019022)) {
				validadorDeDV = DVX_CHECKER_CASO2;
			} else if (3019023 <= ie) {
				validadorDeDV = DVX_CHECKER_CASO3;
			}
			result = validadorDeDV.isDVValid(testedValue);
			
			return result;
		}
	}
}