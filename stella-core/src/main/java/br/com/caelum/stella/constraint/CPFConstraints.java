package br.com.caelum.stella.constraint;

import java.util.regex.Pattern;

/**
 * @author Leonardo Bessa
 * 
 */
public class CPFConstraints {
    public static final Pattern FORMATED = Pattern.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
}
