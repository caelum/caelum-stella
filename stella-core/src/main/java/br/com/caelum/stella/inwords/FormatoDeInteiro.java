package br.com.caelum.stella.inwords;

/**
 * Representa o formato de para números inteiros com precisão de miléssimos.
 * 
 * 
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class FormatoDeInteiro implements FormatoDeExtenso {

    public String getUnidadeDecimalNoPlural() {
        return "milésimos";
    }

    public String getUnidadeDecimalNoSingular() {
        return "milésimo";
    }

    public String getUnidadeInteiraNoSingular() {
        return "inteiro";
    }

    public String getUnidadeInteiraNoPlural() {
        return "inteiros";
    }

    public int getCasasDecimais() {
        return 3;
    }

}
