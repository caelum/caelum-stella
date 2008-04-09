package br.com.caelum.stella.constraint;

import java.util.regex.Pattern;

public class CPFConstraints {
	public static final Pattern CPF_FORMATED = Pattern
			.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");
	public static final Pattern CPF_UNFORMATED = Pattern
			.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
}
