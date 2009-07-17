package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class NFEImpl<T> implements NFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNFe tNFe;
    private final T parent;

    public NFEImpl(final T parent) {
        this.parent = parent;
        tNFe = new br.com.caelum.stella.nfe.modelo.TNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tNFe;
    }

    public NFE<T> withInformacoesDaNFE(final InformacoesDaNFE<?> infNFe) {
        tNFe.setInfNFe((br.com.caelum.stella.nfe.modelo.InfNFe) ((ObjectCreator) infNFe).getInstance());
        return this;
    }

    public NFE<T> withSignature(final SignatureType signatureType) {
        tNFe.setSignature(signatureType);
        return this;
    }
}