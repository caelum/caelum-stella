package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetConsSitNFeImpl<T> implements TRetConsSitNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsSitNFe tRetConsSitNFe;
    private final T parent;

    public TRetConsSitNFeImpl(final T parent) {
        this.parent = parent;
        tRetConsSitNFe = new br.com.caelum.stella.nfe.modelo.TRetConsSitNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetConsSitNFe;
    }

    public TRetConsSitNFe<T> withInfProt(final InfProt infProt) {
        tRetConsSitNFe.setInfProt(infProt);
        return this;
    }

    public TRetConsSitNFe<T> withSignature(final SignatureType signatureType) {
        tRetConsSitNFe.setSignature(signatureType);
        return this;
    }

    public TRetConsSitNFe<T> withVersao(final String string) {
        tRetConsSitNFe.setVersao(string);
        return this;
    }
}