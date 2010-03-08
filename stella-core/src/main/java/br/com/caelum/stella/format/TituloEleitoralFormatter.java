package br.com.caelum.stella.format;


import br.com.caelum.stella.validation.TituloEleitoralValidator;

public class TituloEleitoralFormatter implements Formatter{
	  
	
	private final BaseFormatter base;
	
    public TituloEleitoralFormatter() {
        this.base = new BaseFormatter(TituloEleitoralValidator.FORMATED, "$1/$2",TituloEleitoralValidator.UNFORMATED, "$1$2");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }
	
}
