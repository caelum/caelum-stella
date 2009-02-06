package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class NFrefImpl implements NFref, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.NFref nFref;

    public NFrefImpl() {
        nFref = new br.com.caelum.stella.nfe.modelo.NFref();
    }

    public br.com.caelum.stella.nfe.modelo.NFref getInstance() {
        return nFref;
    }

    public NFref withRefNFe(final String string) {
        nFref.setRefNFe(string);
        return this;
    }

    public NFref withRefNF(final RefNF refNF) {
        nFref.setRefNF((br.com.caelum.stella.nfe.modelo.RefNF) ((ObjectCreator) refNF).getInstance());
        return this;
    }
}