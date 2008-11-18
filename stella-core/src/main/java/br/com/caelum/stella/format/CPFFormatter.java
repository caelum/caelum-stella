package br.com.caelum.stella.format;

import static br.com.caelum.stella.constraint.CPFConstraints.FORMATED;
import static br.com.caelum.stella.constraint.CPFConstraints.UNFORMATED;

/**
 * @author Leonardo Bessa
 * 
 */
public class CPFFormatter implements Formatter {

    private final BaseFormatter base;

    public CPFFormatter() {
        this.base = new BaseFormatter(FORMATED, "$1.$2.$3-$4", UNFORMATED, "$1$2$3$4");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
