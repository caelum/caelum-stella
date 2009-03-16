package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InformacoesDaNFReferenciadaImpl implements InformacoesDaNFReferenciada,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.NFref nFref;

    public InformacoesDaNFReferenciadaImpl() {
        nFref = new br.com.caelum.stella.nfe.modelo.NFref();
    }

    public br.com.caelum.stella.nfe.modelo.NFref getInstance() {
        return nFref;
    }

    public InformacoesDaNFReferenciada withChaveDeAcessoDaNFReferenciada(final String string) {
        nFref.setRefNFe(string);
        return this;
    }

    public InformacoesDaNFReferenciada withNFReferenciada(final NFReferenciada refNF) {
        nFref.setRefNF((br.com.caelum.stella.nfe.modelo.RefNF) ((ObjectCreator) refNF).getInstance());
        return this;
    }
}