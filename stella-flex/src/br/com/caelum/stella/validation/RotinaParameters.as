package br.com.caelum.stella.validation
{
	public class RotinaParameters {
		
		private var _digitoVerificadorInfo:DigitoVerificadorInfo;
		private var _numeros:Array;
		public var result:int;
		
		public function RotinaParameters(digitoVerificadorInfo:DigitoVerificadorInfo, numeros:Array, result:int) {
			this._digitoVerificadorInfo = digitoVerificadorInfo;
			this._numeros = numeros;
			this.result = result;
		}

		public function get digitoVerificadorInfo():DigitoVerificadorInfo { return _digitoVerificadorInfo; }

		public function get numeros():Array { return _numeros; }
	}
}