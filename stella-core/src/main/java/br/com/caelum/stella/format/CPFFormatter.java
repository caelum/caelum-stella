package br.com.caelum.stella.format;

import static br.com.caelum.stella.constraint.CPFConstraints.CPF_FORMATED;
import static br.com.caelum.stella.constraint.CPFConstraints.CPF_UNFORMATED;

/**
 * @author Leonardo Bessa
 * 
 */
public class CPFFormatter implements Formatter {

    private final BaseFormatter base;
    
    public CPFFormatter(){
        this.base = new BaseFormatter(CPF_FORMATED,"$1.$2.$3-$4",CPF_UNFORMATED,"$1$2$3$4");
    }

    public String format(String value) {
        return base.format(value);
    }

    public String unformat(String value) {
        return base.unformat(value);
    }
    
    

}
