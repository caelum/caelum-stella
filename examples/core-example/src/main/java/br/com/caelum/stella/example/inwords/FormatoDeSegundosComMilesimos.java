package br.com.caelum.stella.example.inwords;

import br.com.caelum.stella.inwords.FormatoDeExtenso;

public class FormatoDeSegundosComMilesimos implements FormatoDeExtenso {

    public int getCasasDecimais() {
        return 3;
    }

    public String getUnidadeDecimalNoPlural() {
        return "milésimos de segundo";
    }

    public String getUnidadeDecimalNoSingular() {
        return "milésimo de segundo";
    }

    public String getUnidadeInteiraNoPlural() {
        return "segundos";
    }

    public String getUnidadeInteiraNoSingular() {
        return "segundo";
    }

}
