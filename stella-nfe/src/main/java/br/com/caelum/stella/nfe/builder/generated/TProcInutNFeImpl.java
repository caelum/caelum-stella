package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TProcInutNFeImpl<T> implements TProcInutNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProcInutNFe tProcInutNFe;
    private final T parent;

    public TProcInutNFeImpl(final T parent) {
        this.parent = parent;
        tProcInutNFe = new br.com.caelum.stella.nfe.modelo.TProcInutNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tProcInutNFe;
    }

    public TProcInutNFe<T> withInutNFe(final TInutNFe<?> tInutNFe) {
        tProcInutNFe.setInutNFe((br.com.caelum.stella.nfe.modelo.TInutNFe) ((ObjectCreator) tInutNFe).getInstance());
        return this;
    }

    public TProcInutNFe<T> withRetInutNFe(final TRetInutNFe<?> tRetInutNFe) {
        tProcInutNFe
                    .setRetInutNFe((br.com.caelum.stella.nfe.modelo.TRetInutNFe) ((ObjectCreator) tRetInutNFe)
                                                                                                              .getInstance());
        return this;
    }

    public TProcInutNFe<T> withVersao(final String string) {
        tProcInutNFe.setVersao(string);
        return this;
    }
}