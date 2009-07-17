package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TotalNFEImpl<T> implements TotalNFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Total total;
    private final T parent;

    public TotalNFEImpl(final T parent) {
        this.parent = parent;
        total = new br.com.caelum.stella.nfe.modelo.Total();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.total;
    }

    public TotalNFE<T> withICMSTotal(final ICMSTotal<?> iCMSTot) {
        total.setICMSTot((br.com.caelum.stella.nfe.modelo.ICMSTot) ((ObjectCreator) iCMSTot).getInstance());
        return this;
    }

    public TotalNFE<T> withISSQNTotal(final ISSQNTotal<?> iSSQNtot) {
        total.setISSQNtot((br.com.caelum.stella.nfe.modelo.ISSQNtot) ((ObjectCreator) iSSQNtot).getInstance());
        return this;
    }

    public TotalNFE<T> withRetencaoDeTributosFederais(final RetencaoDeTributosFederais<?> retTrib) {
        total.setRetTrib((br.com.caelum.stella.nfe.modelo.RetTrib) ((ObjectCreator) retTrib).getInstance());
        return this;
    }
}