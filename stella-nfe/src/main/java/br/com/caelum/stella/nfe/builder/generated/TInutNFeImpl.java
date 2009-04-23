package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TInutNFeImpl implements TInutNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TInutNFe tInutNFe;

    public TInutNFeImpl() {
        tInutNFe = new br.com.caelum.stella.nfe.modelo.TInutNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tInutNFe;
    }

    public TInutNFe withInfInut(final InfInut infInut) {
        tInutNFe.setInfInut((br.com.caelum.stella.nfe.modelo.InfInut) ((ObjectCreator) infInut).getInstance());
        return this;
    }

    public TInutNFe withSignature(final SignatureType signatureType) {
        tInutNFe.setSignature(signatureType);
        return this;
    }

    public TInutNFe withVersao(final String string) {
        tInutNFe.setVersao(string);
        return this;
    }
}