package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.RotinaParameters;

	public class IERotinas {
		
		public static function A(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var a:Array = info.pesos;
			var b:Array = parameter.numeros;
			var result:int = parameter.result;
			for (var i:uint = 0; i < a.length; i++) {
				result += (a[i] * b[i]) / 10;
			}
			return result;
		}
		
		public static function B(parameter:RotinaParameters):int {
			return 10 * parameter.result;
		}
		
		public static function C(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var x:int = parameter.result;
			return x + (5 + 4 * info.fator);
		}
		
		public static function D(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var x:int = parameter.result;
			return x % info.mod;
		}
		
		public static function E(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var x:int = parameter.result;
			var result:int = info.mod - (x % info.mod);
			return result;
		}
		
		public static function POS_IE(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var x:int = parameter.result;
			
			if (x === 10) {
				x = 0;
			} else if (x === 11) {
				x = info.fator;
			}
			return x;
		}
		
		public static function POS_IE_GOIAS(parameter:RotinaParameters):int {
			var info:DigitoVerificadorInfo = parameter.digitoVerificadorInfo;
			var x:int = parameter.result;
			
			if (x === 11) {
				x = 0;
			} else if (x === 10) {
				x = info.fator
			}
			return x;
		}
	}
}