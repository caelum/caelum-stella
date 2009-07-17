package br.com.caelum.stella.nfe.builder.generated;

public final class InfCancImpl<T> implements InfCanc<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCanc infCanc;
    private final T parent;

    public InfCancImpl(final T parent) {
        this.parent = parent;
        this.infCanc = new br.com.caelum.stella.nfe.modelo.InfCanc();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.infCanc;
    }

    public InfCanc<T> withTpAmb(final String string) {
        this.infCanc.setTpAmb(string);
        return this;
    }

    public InfCanc<T> withXServ(final String string) {
        this.infCanc.setXServ(string);
        return this;
    }

    public InfCanc<T> withChNFe(final String string) {
        this.infCanc.setChNFe(string);
        return this;
    }

    public InfCanc<T> withNProt(final String string) {
        this.infCanc.setNProt(string);
        return this;
    }

    public InfCanc<T> withXJust(final String string) {
        this.infCanc.setXJust(string);
        return this;
    }

    public InfCanc<T> withId(final String string) {
        this.infCanc.setId(string);
        return this;
    }
}