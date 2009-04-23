package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TProcCancNFeImpl implements TProcCancNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProcCancNFe tProcCancNFe;

    public TProcCancNFeImpl() {
        tProcCancNFe = new br.com.caelum.stella.nfe.modelo.TProcCancNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tProcCancNFe;
    }

    public TProcCancNFe withCancNFe(final TCancNFe tCancNFe) {
        tProcCancNFe.setCancNFe((br.com.caelum.stella.nfe.modelo.TCancNFe) ((ObjectCreator) tCancNFe).getInstance());
        return this;
    }

    public TProcCancNFe withRetCancNFe(final TRetCancNFe tRetCancNFe) {
        tProcCancNFe
                    .setRetCancNFe((br.com.caelum.stella.nfe.modelo.TRetCancNFe) ((ObjectCreator) tRetCancNFe)
                                                                                                              .getInstance());
        return this;
    }

    public TProcCancNFe withVersao(final String string) {
        tProcCancNFe.setVersao(string);
        return this;
    }
}