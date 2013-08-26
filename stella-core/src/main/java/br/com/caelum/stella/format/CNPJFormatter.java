package br.com.caelum.stella.format;

import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.CNPJValidator;

/**
 * @author Leonardo Bessa
 * 
 */
@GwtCompatible
public class CNPJFormatter implements Formatter {
    private final BaseFormatter base;

    public CNPJFormatter() {
        this.base = new BaseFormatter(CNPJValidator.FORMATED, "$1.$2.$3/$4-$5", CNPJValidator.UNFORMATED, "$1$2$3$4$5");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }

}
