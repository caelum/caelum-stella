package br.com.caelum.stella.nfe.builder.generated;

public final class DFeImpl<T> implements DFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.DFe dFe;
    private final T parent;

    public DFeImpl(final T parent) {
        this.parent = parent;
        this.dFe = new br.com.caelum.stella.nfe.modelo.DFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.dFe;
    }

    public DFe<T> withMod(final String string) {
        this.dFe.setMod(string);
        return this;
    }

    public DFe<T> withSit(final String string) {
        this.dFe.setSit(string);
        return this;
    }
}