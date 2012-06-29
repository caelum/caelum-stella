package br.com.caelum.stella.validation
{
	public class DigitoVerificadorInfo {
		
		private var _fator:int;
		private var _rotinas:Array;
		private var _mod:int;
		private var _pesos:Array;
		private var _posicaoDoDv:int;
		
		public function DigitoVerificadorInfo(fator:int, 
											  rotinas:Array, 
											  mod:int, 
											  pesos:Array, 
											  posicaoDoDv:int) {
			this._fator = fator;
			this._rotinas = rotinas;
			this._mod = mod;
			this._pesos = pesos;
			this._posicaoDoDv = posicaoDoDv;
		}
				
		public function get fator():int { return _fator; }

		public function get rotinas():Array { return _rotinas; }

		public function get mod():int { return _mod; }

		public function get pesos():Array { return _pesos; }

		public function get posicaoDoDv():int { return _posicaoDoDv; }
	}
}