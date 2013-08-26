package br.com.caelum.stella.inwords;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
@GwtCompatible
public class FormatoDeReal implements FormatoDeExtenso {

    public String getUnidadeDecimalNoPlural() {
        return "centavos";
    }

    public String getUnidadeDecimalNoSingular() {
        return "centavo";
    }

    public String getUnidadeInteiraNoSingular() {
        return "real";
    }

    public String getUnidadeInteiraNoPlural() {
        return "reais";
    }

    public int getCasasDecimais() {
        return 2;
    }

}
