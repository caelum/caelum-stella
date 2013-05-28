package br.com.caelum.stella.validation
{
	public class ValidadorDeDV {
		
		private var _info:DigitoVerificadorInfo;
		
		public function ValidadorDeDV(info:DigitoVerificadorInfo) {
			this._info = info;
		}
		
		public function isDVValid(digitos:String):Boolean {
			var dvCandidate:int = parseInt(digitos.substring(_info.posicaoDoDv - 1, _info.posicaoDoDv));
			return this.generateDV(digitos) === dvCandidate;
		}
		
		private function generateDV(digitos:String):int {
			var intDigits:Array = extractIntegerDigits(digitos);
			
			var innerProduct:int = innerProduct(_info.pesos, intDigits);
			
			var result:int = innerProduct;
			var parameters:RotinaParameters = new RotinaParameters(_info, intDigits, innerProduct);
			for each (var rotina:Function in _info.rotinas) {
				result = rotina(parameters);
				parameters.result = result;
			}
			
			return result;
		}
		
		private function extractIntegerDigits(digitos:String):Array {
			var intDigits:Array = [];
			
			for (var i:uint = 0; i < digitos.length; i++) {
				intDigits[i] = parseInt(digitos.substring(i, i+1));
			}
			
			return intDigits;
		}
		
		private function innerProduct(a:Array, b:Array):int {
			var result:int = 0;
			
			for (var i:uint = 0; i < a.length; i++) {
				result += a[i] * b[i];
			}
			return result;
		}
	}
}