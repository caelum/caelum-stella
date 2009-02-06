package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TNfeProcImpl implements TNfeProc, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNfeProc tNfeProc;

    public TNfeProcImpl() {
        tNfeProc = new br.com.caelum.stella.nfe.modelo.TNfeProc();
    }

    public br.com.caelum.stella.nfe.modelo.TNfeProc getInstance() {
        return tNfeProc;
    }

    public TNfeProc withNFe(final TNFe tNFe) {
        tNfeProc.setNFe((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) tNFe).getInstance());
        return this;
    }

    public TNfeProc withProtNFe(final TProtNFe tProtNFe) {
        tNfeProc.setProtNFe((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) tProtNFe).getInstance());
        return this;
    }

    public TNfeProc withVersao(final String string) {
        tNfeProc.setVersao(string);
        return this;
    }
}