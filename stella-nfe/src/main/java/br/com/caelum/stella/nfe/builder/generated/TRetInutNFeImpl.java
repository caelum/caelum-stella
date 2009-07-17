package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetInutNFeImpl<T> implements TRetInutNFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetInutNFe tRetInutNFe;
    private final T parent;

    public TRetInutNFeImpl(final T parent) {
        this.parent = parent;
        tRetInutNFe = new br.com.caelum.stella.nfe.modelo.TRetInutNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetInutNFe;
    }

    public TRetInutNFe<T> withInfInut(final InfInut<?> infInut) {
        tRetInutNFe.setInfInut((br.com.caelum.stella.nfe.modelo.InfInut) ((ObjectCreator) infInut).getInstance());
        return this;
    }

    public TRetInutNFe<T> withSignature(final SignatureType signatureType) {
        tRetInutNFe.setSignature(signatureType);
        return this;
    }

    public TRetInutNFe<T> withVersao(final String string) {
        tRetInutNFe.setVersao(string);
        return this;
    }
}