package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.format.LeftSideZerosFormatter;
	import br.com.caelum.stella.validation.DigitoVerificadorInfo;
	import br.com.caelum.stella.validation.RotinaParameters;

	public class IEConstraints {
		
		public static const PRE_VALIDATION_FORMATTER:LeftSideZerosFormatter = new LeftSideZerosFormatter(14);
		
		public static const P1:Array = [6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0];
		
		public static const P2:Array = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0, 0];
		
		public static const P3:Array = [6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 0, 2];
		
		public static const P4:Array = [0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 4, 3, 2, 0];
		
		public static const P5:Array = [0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0];
		
		public static const P6:Array = [0, 0, 0, 9, 8, 0, 0, 7, 6, 5, 4, 3, 2, 0];
		
		public static const P7:Array = [5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 0];
		
		public static const P8:Array = [8, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 0];
		
		public static const P9:Array = [7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 0, 0];
		
		public static const P10:Array = [0, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 0, 0];
		
		public static const P11:Array = [0, 3, 2, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0];
		
		public static const P12:Array = [0, 0, 1, 3, 4, 5, 6, 7, 8, 10, 0, 0, 0, 0];
		
		public static const P13:Array = [0, 0, 3, 2, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0];
	}
}