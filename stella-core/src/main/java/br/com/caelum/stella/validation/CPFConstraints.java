package br.com.caelum.stella.validation;

import java.util.regex.Pattern;

/**
 * @author Leonardo Bessa
 *
 */
class CPFConstraints {
	public static final Pattern CPF_FORMATED = Pattern
			.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");
	public static final Pattern CPF_UNFORMATED = Pattern
			.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
}
