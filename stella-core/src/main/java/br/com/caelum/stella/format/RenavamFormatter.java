package br.com.caelum.stella.format;

import java.util.regex.Pattern;

/**
 * @author Rafael Carvalho
 *
 */
public class RenavamFormatter implements Formatter {

    public static final Pattern FORMATTED = Pattern.compile("(\\d{2}).(\\d{6})-(\\d{1})");
    public static final Pattern UNFORMATTED = Pattern.compile("(\\d{2})(\\d{6})(\\d{1})");

    private final BaseFormatter base;

    public RenavamFormatter() {
        this.base = new BaseFormatter(FORMATTED, "$1.$2-$3", UNFORMATTED, "$1$2$3");
    }

    public String format(String renavam) throws IllegalArgumentException {
        return base.format(renavam);
    }

    public String unformat(String renavam) throws IllegalArgumentException {
        return base.unformat(renavam);
    }

}
