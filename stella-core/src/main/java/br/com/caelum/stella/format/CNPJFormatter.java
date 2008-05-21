package br.com.caelum.stella.format;

import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_FORMATED;
import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_UNFORMATED;
import br.com.caelum.stella.format.Formatter;

import java.util.regex.Matcher;

/**
 * @author Leonardo Bessa
 * 
 */
public class CNPJFormatter implements Formatter {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.stella.conversion.Formatter#format(java.lang.String)
     */
    public String format(String value) {
        String result = null;
        if (value != null) {
            Matcher matcher = CNPJ_UNFORMATED.matcher(value);
            if (matcher.matches()) {
                result = matcher.replaceAll("$1.$2.$3/$4-$5");
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.stella.conversion.Formatter#unformat(java.lang.String)
     */
    public String unformat(String value) {
        String result = null;
        if (value != null) {
            Matcher matcher = CNPJ_FORMATED.matcher(value);
            if (matcher.matches()) {
                result = matcher.replaceAll("$1$2$3$4$5");
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

}
