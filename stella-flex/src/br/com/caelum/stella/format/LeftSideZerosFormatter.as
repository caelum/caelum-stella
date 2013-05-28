package br.com.caelum.stella.format
{
	public class LeftSideZerosFormatter {
		
		private var _formattedLength:int;
		
		public function LeftSideZerosFormatter(formattedLength:int) {
			this._formattedLength = formattedLength;
		}
		
		public function format(value:String):String {			
			var regex:RegExp = new RegExp('\\d{0,' + _formattedLength + '}');
			
			if (!regex.test(value)) {
				throw new Error('Argument value must have only ' + _formattedLength + ' digits at most.');
			}
			
			var formatted:String = value;
			while (formatted.length < _formattedLength) {
				formatted = '0' + formatted;
			}
			return formatted;
		}
		
		public function unformat(value:String):String {
			var integer:int = parseInt(value);
			return integer.toString();
		}
	}
}