package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetInutNFeImpl implements TRetInutNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetInutNFe tRetInutNFe;

    public TRetInutNFeImpl() {
        tRetInutNFe = new br.com.caelum.stella.nfe.modelo.TRetInutNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tRetInutNFe;
    }

    public TRetInutNFe withInfInut(final InfInut infInut) {
        tRetInutNFe.setInfInut((br.com.caelum.stella.nfe.modelo.InfInut) ((ObjectCreator) infInut).getInstance());
        return this;
    }

    public TRetInutNFe withSignature(final SignatureType signatureType) {
        tRetInutNFe.setSignature(signatureType);
        return this;
    }

    public TRetInutNFe withVersao(final String string) {
        tRetInutNFe.setVersao(string);
        return this;
    }
}