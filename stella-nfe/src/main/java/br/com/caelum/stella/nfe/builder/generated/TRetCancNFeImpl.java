package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetCancNFeImpl<T> implements TRetCancNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetCancNFe tRetCancNFe;
    private final T parent;

    public TRetCancNFeImpl(final T parent) {
        this.parent = parent;
        tRetCancNFe = new br.com.caelum.stella.nfe.modelo.TRetCancNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tRetCancNFe;
    }

    public TRetCancNFe<T> withInfCanc(final InfCanc<?> infCanc) {
        tRetCancNFe.setInfCanc((br.com.caelum.stella.nfe.modelo.InfCanc) ((ObjectCreator) infCanc).getInstance());
        return this;
    }

    public TRetCancNFe<T> withSignature(final SignatureType signatureType) {
        tRetCancNFe.setSignature(signatureType);
        return this;
    }

    public TRetCancNFe<T> withVersao(final String string) {
        tRetCancNFe.setVersao(string);
        return this;
    }
}