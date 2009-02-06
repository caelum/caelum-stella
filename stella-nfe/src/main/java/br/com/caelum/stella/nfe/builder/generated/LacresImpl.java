package br.com.caelum.stella.nfe.builder.generated;

public final class LacresImpl implements Lacres, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Lacres lacres;

    public LacresImpl() {
        this.lacres = new br.com.caelum.stella.nfe.modelo.Lacres();
    }

    public br.com.caelum.stella.nfe.modelo.Lacres getInstance() {
        return this.lacres;
    }

    public Lacres withNLacre(String string) {
        this.lacres.setNLacre(string);
        return this;
    }
}