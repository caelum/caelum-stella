package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.ValidadorDeDV;

	public class IEGoiasValidator extends AbstractIEValidator {
		
		private static const MOD:int = 11;		
		private static const DVX_POSITION:int = 5 + 9;		
		private static const DVX_MULTIPLIERS:Array = IEConstraints.P1;		
		private static const rotinas:Array = [IERotinas.E, IERotinas.POS_IE_GOIAS];
		
		private static const DVX_INFO_FATOR1:DigitoVerificadorInfo = new DigitoVerificadorInfo(1, rotinas, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);		
		private static const DVX_INFO_FATOR0:DigitoVerificadorInfo = new DigitoVerificadorInfo(0, rotinas, MOD,
			DVX_MULTIPLIERS, DVX_POSITION);
		
		private static const DVX_CHECKER_FATOR1:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_FATOR1);		
		private static const DVX_CHECKER_FATOR0:ValidadorDeDV = new ValidadorDeDV(DVX_INFO_FATOR0);
		
		/*
		* Formato da Inscrição: AB.CDE.FGH-I 8 dígitos (ABCDEFGH)+1 dígito
		* verificador (I); onde AB pode ser igual a 10 ou 11 ou 15.
		* 
		* CCE de Exemplo: 10.987.654-7
		* 
		* -Atribui-se um peso a cada dígito do CCE seguindo a ordem abaixo:
		* 
		* CCE= 1 0 9 8 7 6 5 4
		* 
		* PESOS= 9 8 7 6 5 4 3 2
		* 
		* 
		* Cálculo:
		* 
		* (9x1)+(8x0)+(7x9)+(6x8)+(5x7)+(4x6)+(3x5)+(2x4)= 202
		* 
		* Divide-se 202 por 11= 18 e sobra 4 (resto)
		* 
		* Quando a inscrição for 11094402 o dígito verificador pode ser zero (0) e
		* pode ser um (1);
		* 
		* Quando o resto da divisão for zero (0), o dígito verificador será zero
		* (0);
		* 
		* Quando o resto da divisão for um (1), e a inscrição for maior ou igual a
		* 10103105 e menor ou igual a 10119997, o dígito verificador será um (1);
		* 
		* Quando o resto da divisão for um (1), e a inscrição estiver fora do
		* intervalo citado acima, o dígito verificador será zero (0);
		* 
		* Quando o resto for diferente de um (1) ou zero (0), o dígito verificador
		* será onze (11) menos o resto. No exemplo acima onze (11) menos quatro (4)
		* é igual a sete (7) que é o dígito verificador da Inscrição 10.987.654-7
		*/		
		public static const FORMATTED:RegExp = /^(1[015])[.](\d{3})[.](\d{3})[-](\d{1})$/;		
		public static const UNFORMATTED:RegExp = /^(1[015])(\d{3})(\d{3})(\d{1})$/;
		
		public function IEGoiasValidator(isFormatted:Boolean = true, messageProducer:MessageProducer = null) {
			super(isFormatted, messageProducer);
		}
		
		override protected function getUnformattedPattern():RegExp {
			return UNFORMATTED;
		}
		
		override protected function getFormattedPattern():RegExp {
			return FORMATTED;
		}
				
		override protected function hasValidCheckDigits(value:String):Boolean {
			var ie:int = parseInt(value);
			var result:Boolean;
			/*
			* http://www.sintegra.gov.br/Cad_Estados/cad_GO.html
			* 
			* Quando a inscrição for 11094402 o dígito verificador pode ser zero
			* (0) e pode ser um (1);
			*/
			if (ie == 110944020 || ie == 110944021) {
				result = true;
			} else {
				var testedValue:String = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
				var validadorDeDV:ValidadorDeDV = null;
				if (101031051 <= ie && ie <= 101199979) {
					validadorDeDV = DVX_CHECKER_FATOR1;
				} else {
					validadorDeDV = DVX_CHECKER_FATOR0;
				}
				result = validadorDeDV.isDVValid(testedValue);
			}
			
			return result;
		}

	}
}