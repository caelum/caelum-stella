package br.com.caelum.stella.format;

import br.com.caelum.stella.validation.CPFValidator;

/**
 * @author Leonardo Bessa
 * 
 */
public class CPFFormatter implements Formatter {

    private final BaseFormatter base;

    public CPFFormatter() {
        this.base = new BaseFormatter(CPFValidator.FORMATED, "$1.$2.$3-$4", CPFValidator.UNFORMATED, "$1$2$3$4");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
