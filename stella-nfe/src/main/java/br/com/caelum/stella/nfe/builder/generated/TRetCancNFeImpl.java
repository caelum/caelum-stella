package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetCancNFeImpl implements TRetCancNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetCancNFe tRetCancNFe;

    public TRetCancNFeImpl() {
        tRetCancNFe = new br.com.caelum.stella.nfe.modelo.TRetCancNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tRetCancNFe;
    }

    public TRetCancNFe withInfCanc(final InfCanc infCanc) {
        tRetCancNFe.setInfCanc((br.com.caelum.stella.nfe.modelo.InfCanc) ((ObjectCreator) infCanc).getInstance());
        return this;
    }

    public TRetCancNFe withSignature(final SignatureType signatureType) {
        tRetCancNFe.setSignature(signatureType);
        return this;
    }

    public TRetCancNFe withVersao(final String string) {
        tRetCancNFe.setVersao(string);
        return this;
    }
}