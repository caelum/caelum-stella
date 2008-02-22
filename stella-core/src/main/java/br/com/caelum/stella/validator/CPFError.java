package br.com.caelum.stella.validator;
/**
 * @Author Leonardo Bessa
 */
public enum CPFError {
	INVALID_CHECK_DIGITS, INVALID_DIGITS_PATTERN, ALL_REPEATED_DIGITS_FAUL;

	public String getMessage() {
		return this.toString();
	}

}