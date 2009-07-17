package br.com.caelum.stella.nfe.builder.generated;

public final class TConsStatServImpl<T> implements TConsStatServ<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsStatServ tConsStatServ;
    private final T parent;

    public TConsStatServImpl(final T parent) {
        this.parent = parent;
        this.tConsStatServ = new br.com.caelum.stella.nfe.modelo.TConsStatServ();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tConsStatServ;
    }

    public TConsStatServ<T> withTpAmb(final String string) {
        this.tConsStatServ.setTpAmb(string);
        return this;
    }

    public TConsStatServ<T> withCUF(final String string) {
        this.tConsStatServ.setCUF(string);
        return this;
    }

    public TConsStatServ<T> withXServ(final String string) {
        this.tConsStatServ.setXServ(string);
        return this;
    }

    public TConsStatServ<T> withVersao(final String string) {
        this.tConsStatServ.setVersao(string);
        return this;
    }
}