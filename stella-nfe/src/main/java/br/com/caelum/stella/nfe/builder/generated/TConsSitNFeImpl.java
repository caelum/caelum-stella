package br.com.caelum.stella.nfe.builder.generated;

public final class TConsSitNFeImpl<T> implements TConsSitNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsSitNFe tConsSitNFe;
    private final T parent;

    public TConsSitNFeImpl(final T parent) {
        this.parent = parent;
        this.tConsSitNFe = new br.com.caelum.stella.nfe.modelo.TConsSitNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tConsSitNFe;
    }

    public TConsSitNFe<T> withTpAmb(final String string) {
        this.tConsSitNFe.setTpAmb(string);
        return this;
    }

    public TConsSitNFe<T> withXServ(final String string) {
        this.tConsSitNFe.setXServ(string);
        return this;
    }

    public TConsSitNFe<T> withChNFe(final String string) {
        this.tConsSitNFe.setChNFe(string);
        return this;
    }

    public TConsSitNFe<T> withVersao(final String string) {
        this.tConsSitNFe.setVersao(string);
        return this;
    }
}