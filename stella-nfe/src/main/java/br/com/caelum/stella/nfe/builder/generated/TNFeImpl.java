package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TNFeImpl implements TNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNFe tNFe;

    public TNFeImpl() {
        tNFe = new br.com.caelum.stella.nfe.modelo.TNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TNFe getInstance() {
        return tNFe;
    }

    public TNFe withInfNFe(final InfNFe infNFe) {
        tNFe.setInfNFe((br.com.caelum.stella.nfe.modelo.InfNFe) ((ObjectCreator) infNFe).getInstance());
        return this;
    }

    public TNFe withSignature(final SignatureType signatureType) {
        tNFe.setSignature(signatureType);
        return this;
    }
}