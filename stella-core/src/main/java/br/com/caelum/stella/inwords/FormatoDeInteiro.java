package br.com.caelum.stella.inwords;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class FormatoDeInteiro implements FormatoDeExtenso {

    public String getDecimais() {
        return "milésimos";
    }

    public String getDecimal() {
        return "milésimo";
    }

    public String getUnidade() {
        return "inteiro";
    }

    public String getUnidades() {
        return "inteiros";
    }

    public int getCasasDecimais() {
        return 3;
    }

}
