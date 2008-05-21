package br.com.caelum.stella.constraint;

import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.RotinaParameters;

import java.util.regex.Pattern;

/**
 * @author Leonardo Bessa
 * 
 */
public class CNPJConstraints {

    public static final Pattern CNPJ_FORMATED = Pattern.compile("(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})");
    public static final Pattern CNPJ_UNFORMATED = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");

    public enum Rotina implements RotinaDeDigitoVerificador {
        POS_PRODUTO_INTERNO {
            public Integer transform(RotinaParameters parameter) {
                Integer mod = parameter.getDigitoVerificadorInfo().getMod();
                Integer result = parameter.getResult() % mod;
                if (result < 2) {
                    result = 0;
                } else {
                    result = 11 - result;
                }
                return result;
            }
        }
    }
}
