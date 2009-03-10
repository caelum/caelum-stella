package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class NFEProcessadaImpl implements NFEProcessada, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNfeProc tNfeProc;

    public NFEProcessadaImpl() {
        tNfeProc = new br.com.caelum.stella.nfe.modelo.TNfeProc();
    }

    public br.com.caelum.stella.nfe.modelo.TNfeProc getInstance() {
        return tNfeProc;
    }

    public NFEProcessada withNFE(final NFE tNFe) {
        tNfeProc.setNFe((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) tNFe).getInstance());
        return this;
    }

    public NFEProcessada withProtocoloDoResultadoDeProcessamento(final ProtocoloDoResultadoDeProcessamento tProtNFe) {
        tNfeProc.setProtNFe((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) tProtNFe).getInstance());
        return this;
    }

    public NFEProcessada withVersao(final String string) {
        tNfeProc.setVersao(string);
        return this;
    }
}