package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCancNFeImpl implements TCancNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TCancNFe tCancNFe;

    public TCancNFeImpl() {
        tCancNFe = new br.com.caelum.stella.nfe.modelo.TCancNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tCancNFe;
    }

    public TCancNFe withInfCanc(final InfCanc infCanc) {
        tCancNFe.setInfCanc((br.com.caelum.stella.nfe.modelo.InfCanc) ((ObjectCreator) infCanc).getInstance());
        return this;
    }

    public TCancNFe withSignature(final SignatureType signatureType) {
        tCancNFe.setSignature(signatureType);
        return this;
    }

    public TCancNFe withVersao(final String string) {
        tCancNFe.setVersao(string);
        return this;
    }
}