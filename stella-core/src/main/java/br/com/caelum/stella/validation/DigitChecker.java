package br.com.caelum.stella.validation;

import java.util.List;
import java.util.Map;

/**
 * @author Leonardo Bessa
 */
public abstract class DigitChecker {
	private Map<Integer, List<Integer>> dvMulipliers;
	private int mod;

	public DigitChecker(Map<Integer, List<Integer>> dvMulipliers, int mod) {
		this.dvMulipliers = dvMulipliers;
		this.mod = mod;
	}

	public boolean hasValidCheckDigits(String digits) {
		Integer[] intDigits = new Integer[digits.length()];
		for (int i = 0; i < intDigits.length; i++) {
			intDigits[i] = Integer.parseInt("" + digits.charAt(i));
		}
		for (Integer position: dvMulipliers.keySet()) {
			Integer checkDigitCandidate = intDigits[position-1];
			Integer determinedDV = determineCheckDigit(intDigits, position);
			if (!checkDigitCandidate.equals(determinedDV)){
				return false;
			}
		}
		return true;
	}

	private Integer determineCheckDigit(Integer[] digits, int checkDigitPosition) {
		int resultado;
		Integer[] multipliers = new Integer[0];
		multipliers = dvMulipliers.get(checkDigitPosition).toArray(multipliers);
		int resto = innerProduct(multipliers, digits) % mod;
		resultado = rotinaPosProdutoInterno(resto);
		return resultado;
	}

	protected abstract int rotinaPosProdutoInterno(int resto);

	private Integer innerProduct(Integer[] a, Integer[] b) {
		Integer result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i] * b[i];
		}
		return result;
	}

}
