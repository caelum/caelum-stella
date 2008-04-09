package br.com.caelum.stella.constraint;

import java.util.regex.Pattern;

public class CNPJConstraints {

	public static final Pattern CNPJ_FORMATED = Pattern
			.compile("(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})");
	public static final Pattern CNPJ_UNFORMATED = Pattern
			.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");
}
