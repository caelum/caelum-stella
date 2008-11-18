package br.com.caelum.stella.format;

import static br.com.caelum.stella.constraint.CNPJConstraints.FORMATED;
import static br.com.caelum.stella.constraint.CNPJConstraints.UNFORMATED;

/**
 * @author Leonardo Bessa
 * 
 */
public class CNPJFormatter implements Formatter {
    private final BaseFormatter base;

    public CNPJFormatter() {
        this.base = new BaseFormatter(FORMATED, "$1.$2.$3/$4-$5", UNFORMATED, "$1$2$3$4$5");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
