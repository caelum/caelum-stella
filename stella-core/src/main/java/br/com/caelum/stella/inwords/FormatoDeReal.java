package br.com.caelum.stella.inwords;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 *
 */
public class FormatoDeReal implements FormatoDeExtenso {

    public String getDecimais() {
        return "centavos";
    }

    public String getDecimal() {
        return "centavo";
    }

    public String getUnidade() {
        return "real";
    }

    public String getUnidades() {
        return "reais";
    }

    public int getCasasDecimais() {
        return 2;
    }

}
