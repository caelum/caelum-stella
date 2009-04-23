package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TProcInutNFeImpl implements TProcInutNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProcInutNFe tProcInutNFe;

    public TProcInutNFeImpl() {
        tProcInutNFe = new br.com.caelum.stella.nfe.modelo.TProcInutNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tProcInutNFe;
    }

    public TProcInutNFe withInutNFe(final TInutNFe tInutNFe) {
        tProcInutNFe.setInutNFe((br.com.caelum.stella.nfe.modelo.TInutNFe) ((ObjectCreator) tInutNFe).getInstance());
        return this;
    }

    public TProcInutNFe withRetInutNFe(final TRetInutNFe tRetInutNFe) {
        tProcInutNFe
                    .setRetInutNFe((br.com.caelum.stella.nfe.modelo.TRetInutNFe) ((ObjectCreator) tRetInutNFe)
                                                                                                              .getInstance());
        return this;
    }

    public TProcInutNFe withVersao(final String string) {
        tProcInutNFe.setVersao(string);
        return this;
    }
}