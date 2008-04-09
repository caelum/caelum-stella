package br.com.caelum.stella.constraint;

import java.util.regex.Pattern;

public class NITConstraints {
	public static final Pattern NIT_FORMATED = Pattern.compile("(\\d{3})[.](\\d{5})[.](\\d{2})-(\\d{1})");
	public static final Pattern NIT_UNFORMATED = Pattern.compile("(\\d{3})(\\d{5})(\\d{2})(\\d{1})");
}
