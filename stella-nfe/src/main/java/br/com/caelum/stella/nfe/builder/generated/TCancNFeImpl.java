package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCancNFeImpl<T> implements TCancNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TCancNFe tCancNFe;
    private final T parent;

    public TCancNFeImpl(final T parent) {
        this.parent = parent;
        tCancNFe = new br.com.caelum.stella.nfe.modelo.TCancNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tCancNFe;
    }

    public TCancNFe<T> withInfCanc(final InfCanc<?> infCanc) {
        tCancNFe.setInfCanc((br.com.caelum.stella.nfe.modelo.InfCanc) ((ObjectCreator) infCanc).getInstance());
        return this;
    }

    public TCancNFe<T> withSignature(final SignatureType signatureType) {
        tCancNFe.setSignature(signatureType);
        return this;
    }

    public TCancNFe<T> withVersao(final String string) {
        tCancNFe.setVersao(string);
        return this;
    }
}