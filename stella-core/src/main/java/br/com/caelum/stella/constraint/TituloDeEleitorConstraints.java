package br.com.caelum.stella.constraint;

import java.util.regex.Pattern;

import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.RotinaParameters;

/**
 * @author Leonardo Bessa
 * 
 */
public class TituloDeEleitorConstraints {

    public static final Pattern TITULO_DE_ELEITOR_PATTERN = Pattern.compile("(\\d{12})");

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
