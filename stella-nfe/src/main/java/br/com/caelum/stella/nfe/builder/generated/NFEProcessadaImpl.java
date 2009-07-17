package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class NFEProcessadaImpl<T> implements NFEProcessada<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNfeProc tNfeProc;
    private final T parent;

    public NFEProcessadaImpl(final T parent) {
        this.parent = parent;
        tNfeProc = new br.com.caelum.stella.nfe.modelo.TNfeProc();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tNfeProc;
    }

    public NFEProcessada<T> withNFE(final NFE<?> tNFe) {
        tNfeProc.setNFe((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) tNFe).getInstance());
        return this;
    }

    public NFEProcessada<T> withProtocoloDoResultadoDeProcessamento(
            final ProtocoloDoResultadoDeProcessamento<?> tProtNFe) {
        tNfeProc.setProtNFe((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) tProtNFe).getInstance());
        return this;
    }

    public NFEProcessada<T> withVersao(final String string) {
        tNfeProc.setVersao(string);
        return this;
    }
}