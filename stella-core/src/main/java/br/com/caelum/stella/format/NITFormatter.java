package br.com.caelum.stella.format;

import br.com.caelum.stella.validation.NITValidator;

/**
 * @author Leonardo Bessa
 */
public class NITFormatter implements Formatter {

    private final BaseFormatter base;

    public NITFormatter() {
        this.base = new BaseFormatter(NITValidator.NIT_FORMATED, "$1.$2.$3-$4", NITValidator.NIT_UNFORMATED, "$1$2$3$4");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
