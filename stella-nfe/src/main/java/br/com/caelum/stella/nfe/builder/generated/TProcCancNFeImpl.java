package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TProcCancNFeImpl<T> implements TProcCancNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProcCancNFe tProcCancNFe;
    private final T parent;

    public TProcCancNFeImpl(final T parent) {
        this.parent = parent;
        tProcCancNFe = new br.com.caelum.stella.nfe.modelo.TProcCancNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tProcCancNFe;
    }

    public TProcCancNFe<T> withCancNFe(final TCancNFe<?> tCancNFe) {
        tProcCancNFe.setCancNFe((br.com.caelum.stella.nfe.modelo.TCancNFe) ((ObjectCreator) tCancNFe).getInstance());
        return this;
    }

    public TProcCancNFe<T> withRetCancNFe(final TRetCancNFe<?> tRetCancNFe) {
        tProcCancNFe
                    .setRetCancNFe((br.com.caelum.stella.nfe.modelo.TRetCancNFe) ((ObjectCreator) tRetCancNFe)
                                                                                                              .getInstance());
        return this;
    }

    public TProcCancNFe<T> withVersao(final String string) {
        tProcCancNFe.setVersao(string);
        return this;
    }
}