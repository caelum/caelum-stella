package br.com.caelum.stella.format;

import static br.com.caelum.stella.constraint.NITConstraints.NIT_FORMATED;
import static br.com.caelum.stella.constraint.NITConstraints.NIT_UNFORMATED;

/**
 * @author Leonardo Bessa
 */
public class NITFormatter implements Formatter {

    private final BaseFormatter base;

    public NITFormatter() {
        this.base = new BaseFormatter(NIT_FORMATED, "$1.$2.$3-$4", NIT_UNFORMATED, "$1$2$3$4");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
