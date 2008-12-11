package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.modelo.Imposto;

public class Impostos {

    private final Imposto imposto = new Imposto();

    public Impostos addICMS(ICMS icms) {
        return this;
    }

    public Impostos addIPI() {
        return this;
    }

    public Impostos addII() {
        return this;
    }

    public Impostos addPIS() {
        return this;
    }

    public Impostos addPISST() {
        return this;
    }

    public Impostos addCOFINS() {
        return this;
    }

    public Impostos addCOFINSST() {
        return this;
    }

    public Impostos addISSQN() {
        return this;
    }

}
