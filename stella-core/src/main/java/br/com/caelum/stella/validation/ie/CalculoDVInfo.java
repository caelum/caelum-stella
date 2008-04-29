package br.com.caelum.stella.validation.ie;

/**
 * @author Leonardo Bessa
 */
public class CalculoDVInfo {

	interface Rotina {
		Integer transform(Integer x);
	}

	interface RequiresDigits {
		void setDigits(Integer[] numeros);
	}

	private class RotinaA implements Rotina, RequiresDigits {

		private Integer[] numeros;

		public Integer transform(Integer x) {
			Integer[] a = TABELA_DE_PESOS;
			Integer[] b = numeros;
			Integer result = 0;
			int somaDosQuocientes = 0;
			for (int i = 0; i < a.length; i++) {
				somaDosQuocientes = (a[i] * b[i]) / 10;
			}
			result = somaDosQuocientes + x;
			return result;
		}

		public void setDigits(Integer[] numeros) {
			this.numeros = numeros;
		}
	}

	private class RotinaB implements Rotina {
		public Integer transform(Integer x) {
			return 10 * x;
		}
	}

	private class RotinaC implements Rotina {
		public Integer transform(Integer x) {
			return x + (5 + 4 * FATOR);
		}
	}

	private class RotinaD implements Rotina {
		public Integer transform(Integer x) {
			return x % MOD;
		}
	}

	private class RotinaE implements Rotina {
		public Integer transform(Integer x) {
			return (MOD) - (x % MOD);
		}
	}

	private static final Integer[] P1 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3,
			2, 1 };
	private static final Integer[] P2 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2,
			0, 0 };
	private static final Integer[] P3 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3,
			0, 2 };
	private static final Integer[] P4 = { 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 4, 3,
			2, 0 };
	private static final Integer[] P5 = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7,
			8, 0 };
	private static final Integer[] P6 = { 0, 0, 0, 9, 8, 0, 0, 7, 6, 5, 4, 3,
			2, 0 };
	private static final Integer[] P7 = { 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
			2, 0 };
	private static final Integer[] P8 = { 8, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3,
			2, 0 };
	private static final Integer[] P9 = { 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2,
			0, 0 };
	private static final Integer[] P10 = { 0, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2,
			0, 0 };
	private static final Integer[] P11 = { 0, 3, 2, 11, 10, 9, 8, 7, 6, 5, 4,
			3, 2, 0 };
	public static final Integer[] P12 = { 0, 0, 1, 3, 4, 5, 6, 7, 8, 10, 0, 0,
			0, 0 };
	public static final Integer[] P13 = { 0, 0, 3, 2, 10, 9, 8, 7, 6, 5, 4, 3,
			2, 0 };

	public static final Integer[][] PESOS = { P1, P2, P3, P4, P5, P6, P7, P8,
			P9, P10, P11, P12, P13 };

	private final Rotina[] ROTINAS;
	private final Integer MOD;
	private final Integer[] TABELA_DE_PESOS;
	private final Integer FATOR;
	private final Integer POSICAO_DO_DV;

	public enum RotinaCode {
		A, B, C, D, E;
	}

	public CalculoDVInfo(Integer fator, RotinaCode[] rotinaCodes, Integer mod,
			int codigoDosPesos, Integer posicaoDoDv) {
		FATOR = fator;
		ROTINAS = new Rotina[rotinaCodes.length];
		for (int i = 0; i < rotinaCodes.length; i++) {
			ROTINAS[i] = getRotina(rotinaCodes[i]);
		}
		MOD = mod;
		POSICAO_DO_DV = posicaoDoDv;
		TABELA_DE_PESOS = tabelaDePesos(codigoDosPesos);
	}

	private Rotina getRotina(RotinaCode code) {
		switch (code) {
		case A:
			return this.new RotinaA();
		case B:
			return this.new RotinaB();
		case C:
			return this.new RotinaC();
		case D:
			return this.new RotinaD();
		case E:
			return this.new RotinaE();
		}
		throw new IllegalArgumentException();
	}

	private Integer[] tabelaDePesos(int code) {
		if (code < 1 || code > 13) {
			throw new IllegalArgumentException();
		}
		return PESOS[code - 1];
	}

	public boolean DVisValid(String digitos) {
		boolean isValid = false;

		Integer dvCandidate = Integer.parseInt(digitos.substring(
				POSICAO_DO_DV - 1, POSICAO_DO_DV));
		Integer dv = generateDV(digitos);
		if (dv.equals(dvCandidate)) {
			isValid = true;
		}
		return isValid;

	}

	private Integer generateDV(String digitos) {
		Integer[] intDigits = new Integer[digitos.length()];
		for (int i = 0; i < digitos.length(); i++) {
			intDigits[i] = Integer.parseInt(digitos.substring(i, i + 1));
		}
		Integer innerProduct = innerProduct(TABELA_DE_PESOS, intDigits);
		Integer result = innerProduct;
		for (Rotina rotina : ROTINAS) {
			if (rotina instanceof RequiresDigits) {
				((RequiresDigits) rotina).setDigits(intDigits);
			}
			result = rotina.transform(result);
		}
		Integer dv = result;
		if (dv == 10) {
			dv = 0;
		} else if (dv == 11) {
			dv = FATOR;
		}
		return dv;
	}

	private Integer innerProduct(Integer[] a, Integer[] b) {
		Integer result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i] * b[i];
		}
		return result;
	}
}
