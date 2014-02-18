package br.com.caelum.stella.format;


import br.com.caelum.stella.validation.TituloEleitoralValidator;

public class TituloEleitoralFormatter implements Formatter{

	private final BaseFormatter base;

    public TituloEleitoralFormatter() {
        this.base = new BaseFormatter(TituloEleitoralValidator.FORMATED, "$1/$2",TituloEleitoralValidator.UNFORMATED, "$1$2");
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
