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
