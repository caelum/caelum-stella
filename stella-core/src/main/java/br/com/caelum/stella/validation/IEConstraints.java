package br.com.caelum.stella.validation;


public class IEConstraints {
	
	public static final Integer[] P1 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3,
			2, 1 };
	public static final Integer[] P2 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2,
			0, 0 };
	public static final Integer[] P3 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3,
			0, 2 };
	public static final Integer[] P4 = { 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 4, 3,
			2, 0 };
	public static final Integer[] P5 = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7,
			8, 0 };
	public static final Integer[] P6 = { 0, 0, 0, 9, 8, 0, 0, 7, 6, 5, 4, 3,
			2, 0 };
	public static final Integer[] P7 = { 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
			2, 0 };
	public static final Integer[] P8 = { 8, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3,
			2, 0 };
	public static final Integer[] P9 = { 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2,
			0, 0 };
	public static final Integer[] P10 = { 0, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2,
			0, 0 };
	public static final Integer[] P11 = { 0, 3, 2, 11, 10, 9, 8, 7, 6, 5, 4,
			3, 2, 0 };
	public static final Integer[] P12 = { 0, 0, 1, 3, 4, 5, 6, 7, 8, 10, 0, 0,
			0, 0 };
	public static final Integer[] P13 = { 0, 0, 3, 2, 10, 9, 8, 7, 6, 5, 4, 3,
			2, 0 };
	public static final Integer[] P14 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3,
		2, 0 };

	public enum Rotina implements RotinaDeDigitoVerificador {
		A {
			public Integer transform(RotinaParameters parameter) {
				DigitoVerificadorInfo info = parameter
						.getDigitoVerificadorInfo();
				Integer[] a = info.getPesos();
				Integer[] b = parameter.getNumeros();
				Integer result = 0;
				int somaDosQuocientes = 0;
				for (int i = 0; i < a.length; i++) {
					somaDosQuocientes = (a[i] * b[i]) / 10;
				}
				result = somaDosQuocientes + parameter.getResult();
				return result;
			}
		},
		B {

			public Integer transform(RotinaParameters parameter) {
				return 10 * parameter.getResult();
			}
		},
		C {
			public Integer transform(RotinaParameters parameter) {
				DigitoVerificadorInfo info = parameter
						.getDigitoVerificadorInfo();
				Integer x = parameter.getResult();
				return x + (5 + 4 * info.getFator());
			}
		},
		D {
			public Integer transform(RotinaParameters parameter) {
				DigitoVerificadorInfo info = parameter
						.getDigitoVerificadorInfo();
				Integer x = parameter.getResult();
				return x % info.getMod();
			}
		},
		E {
			public Integer transform(RotinaParameters parameter) {
				DigitoVerificadorInfo info = parameter
						.getDigitoVerificadorInfo();
				Integer x = parameter.getResult();
				return (info.getMod()) - (x % info.getMod());
			}
		},
		POS_IE {
			public Integer transform(RotinaParameters parameter) {
				DigitoVerificadorInfo info = parameter
						.getDigitoVerificadorInfo();
				Integer x = parameter.getResult();
				if (x == 10) {
					x = 0;
				} else if (x == 11) {
					x = info.getFator();
				}
				return x;
			}
		};

		public abstract Integer transform(RotinaParameters parameters);

	}

}
