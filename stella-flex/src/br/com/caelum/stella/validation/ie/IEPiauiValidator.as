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
	 * href="http://www.sintegra.gov.br/Cad_Estados/cad_PI.html">SINTEGRA - ROTEIRO
	 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
	 * 
	 * @author Leonardo Bessa
	 * 
	 */
	public class IEPiauiValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;
		private static const DVX_POSITION:int = 5 + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		/*
		* Formato: 8 dígitos (empresa)+1 dígito verificador Exemplo: 19.301.656-7
		*/		
		public static const FORMATTED:RegExp = /^(\d{2})[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^(\d{8})(\d{1})$/;
		
		public function IEPiauiValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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