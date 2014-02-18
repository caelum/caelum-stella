package br.com.caelum.stella.format;

import br.com.caelum.stella.validation.NITValidator;

/**
 * @author Leonardo Bessa
 */
public class NITFormatter implements Formatter {

    private final BaseFormatter base;

    public NITFormatter() {
        this.base = new BaseFormatter(NITValidator.FORMATED, "$1.$2.$3-$4", NITValidator.UNFORMATED, "$1$2$3$4");
    }

    @Override
	public String format(String value) {
        return base.format(value);
    }

    @Override
	public String unformat(String value) {
        return base.unformat(value);
    }

    @Override
    public boolean isFormatted(String value) {
    	return base.isFormatted(value);
    }

    @Override
    public boolean canBeFormatted(String value) {
    	return base.canBeFormatted(value);
    }
}
