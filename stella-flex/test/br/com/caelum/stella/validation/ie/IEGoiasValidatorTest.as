package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

	public class IEGoiasValidatorTest extends IEValidatorTest {
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
		
		private static const wrongCheckDigitUnformattedString:String = '109876542';		
		private static const validUnformattedString:String = '109876547';		
		private static const validFormattedString:String = '10.987.654-7';		
		private static const validValues:Array = [validFormattedString, '10.103.119-1'];
		
		public function IEGoiasValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEGoiasValidator(isFormatted, messageProducer);
		}
	}
}