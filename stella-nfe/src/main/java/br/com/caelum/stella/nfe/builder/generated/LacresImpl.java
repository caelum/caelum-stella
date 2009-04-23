package br.com.caelum.stella.nfe.builder.generated;

public final class LacresImpl implements Lacres, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Lacres lacres;

    public LacresImpl() {
        lacres = new br.com.caelum.stella.nfe.modelo.Lacres();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.lacres;
    }

    public Lacres withNumeroDosLacres(final String string) {
        lacres.setNLacre(string);
        return this;
    }
}