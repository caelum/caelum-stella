package br.com.caelum.stella.nfe.builder.generated;

public final class LacresImpl<T> implements Lacres<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Lacres lacres;
    private final T parent;

    public LacresImpl(final T parent) {
        this.parent = parent;
        lacres = new br.com.caelum.stella.nfe.modelo.Lacres();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.lacres;
    }

    public Lacres<T> withNumeroDosLacres(final String string) {
        lacres.setNLacre(string);
        return this;
    }
}