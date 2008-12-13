package br.com.caelum.stella.nfe.builder;

public class Impostos {

    private Impostos() {
    }

    public static Impostos create() {
        return new Impostos();
    }

    public Impostos withIPI() {
        return this;
    }

    public Impostos withII() {
        return this;
    }

    public Impostos withPIS() {
        return this;
    }

    public Impostos withPISST() {
        return this;
    }

    public Impostos withCOFINS() {
        return this;
    }

    public Impostos withCOFINSST() {
        return this;
    }

    public Impostos withISSQN() {
        return this;
    }

    public Impostos withICMS(final ICMS... icms) {
        return this;
    }

}
