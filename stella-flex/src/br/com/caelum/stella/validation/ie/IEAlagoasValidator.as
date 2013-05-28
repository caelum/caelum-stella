package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IEAlagoasValidator extends AbstractIEValidator {		
		
		private static const MOD:int = 11;
		
		private static const DVX_POSITION:int = 5 + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.B, IERotinas.D, IERotinas.POS_IE];		
		private static const DVX_INFO:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
			DVX_POSITION);		
		private static const DVX_CHECKER:ValidadorDeDV = new ValidadorDeDV(DVX_INFO);
		
		/*
		* FORMAÇÃO: 24XNNNNND, sendo:
		* 
		* 24 – Código do Estado
		* 
		* X – Tipo de empresa (0-Normal, 3-Produtor Rural,5-Substituta, 7-
		* Micro-Empresa Ambulante, 8-Micro-Empresa)
		* 
		* NNNNN – Número da empresa
		* 
		* D – Dígito de verificação calculado pelo Módulo11,pêsos 2 à 9 da direita
		* para a esquerda, exceto D
		* 
		* Exemplo: 2 4 0 0 0 0 0 4 8
		*/
		
		public static const FORMATTED:RegExp = /^([2][4])[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^([2][4])(\d{3})(\d{3})(\d{1})$/;
		
		public function IEAlagoasValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
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