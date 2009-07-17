package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TInutNFeImpl<T> implements TInutNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TInutNFe tInutNFe;
    private final T parent;

    public TInutNFeImpl(final T parent) {
        this.parent = parent;
        tInutNFe = new br.com.caelum.stella.nfe.modelo.TInutNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tInutNFe;
    }

    public TInutNFe<T> withInfInut(final InfInut<?> infInut) {
        tInutNFe.setInfInut((br.com.caelum.stella.nfe.modelo.InfInut) ((ObjectCreator) infInut).getInstance());
        return this;
    }

    public TInutNFe<T> withSignature(final SignatureType signatureType) {
        tInutNFe.setSignature(signatureType);
        return this;
    }

    public TInutNFe<T> withVersao(final String string) {
        tInutNFe.setVersao(string);
        return this;
    }
}