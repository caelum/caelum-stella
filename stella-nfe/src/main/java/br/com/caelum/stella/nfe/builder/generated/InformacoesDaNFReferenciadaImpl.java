package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InformacoesDaNFReferenciadaImpl implements InformacaoDaNFReferenciada,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.NFref nFref;

    public InformacoesDaNFReferenciadaImpl() {
        nFref = new br.com.caelum.stella.nfe.modelo.NFref();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.nFref;
    }

    public InformacaoDaNFReferenciada withChaveDeAcessoDaNFReferenciada(final String string) {
        nFref.setRefNFe(string);
        return this;
    }

    public InformacaoDaNFReferenciada withNFReferenciada(final NFReferenciada refNF) {
        nFref.setRefNF((br.com.caelum.stella.nfe.modelo.RefNF) ((ObjectCreator) refNF).getInstance());
        return this;
    }
}