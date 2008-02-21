package br.com.caelum.stella.validator;
/**
 * @Author Leonardo Bessa
 */
public enum CNPJError {
	CHECK_DIGITS_MISSMATCH, DIGITS_MISSMATCH, ALL_REPEATED_DIGITS_FAUL;

	public String getMessage() {
		return this.toString();
	}

}
