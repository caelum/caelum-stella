package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InformacoesDaNFReferenciadaImpl<T> implements InformacaoDaNFReferenciada<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.NFref nFref;
    private final T parent;

    public InformacoesDaNFReferenciadaImpl(final T parent) {
        this.parent = parent;
        nFref = new br.com.caelum.stella.nfe.modelo.NFref();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.nFref;
    }

    public InformacaoDaNFReferenciada<T> withChaveDeAcessoDaNFReferenciada(final String string) {
        nFref.setRefNFe(string);
        return this;
    }

    public InformacaoDaNFReferenciada<T> withNFReferenciada(final NFReferenciada<?> refNF) {
        nFref.setRefNF((br.com.caelum.stella.nfe.modelo.RefNF) ((ObjectCreator) refNF).getInstance());
        return this;
    }
}