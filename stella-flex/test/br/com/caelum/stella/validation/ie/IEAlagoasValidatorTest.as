package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.validation.StellaValidator;

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
	public class IEAlagoasValidatorTest extends IEValidatorTest {
		
		private static const wrongCheckDigitUnformattedString:String = '240000040';		
		private static const validUnformattedString:String = '240000048';	
		private static const validFormattedString:String = '24.000.004-8';
		
		private static const validValues:Array = ['24.076.739-0', '24.103.644-5', '24.089.826-5', '24.099.991-6',
			'24.067.173-2', '24.102.358-0', '24.079.990-9', '24.089.451-0', '24.080.152-0', '24.092.497-5',
			'24.095.056-9', '24.099.899-5', '24.104.510-0', '24.069.666-2', '24.088.932-0', '24.097.262-7',
			'24.086.162-0', '24.097.871-4', '24.085.016-5', '24.073.874-8', '24.071.760-0', '24.065.706-3',
			'24.054.337-8', '24.102.324-6', '24.105.106-1', '24.104.536-3', '24.086.313-5', '24.089.826-5'];
		
		public function IEAlagoasValidatorTest() {
			super(wrongCheckDigitUnformattedString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEAlagoasValidator(isFormatted, messageProducer);
		}
	}
}