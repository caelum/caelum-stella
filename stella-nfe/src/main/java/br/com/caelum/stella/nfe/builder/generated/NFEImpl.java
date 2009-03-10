package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class NFEImpl implements NFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TNFe tNFe;

    public NFEImpl() {
        tNFe = new br.com.caelum.stella.nfe.modelo.TNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TNFe getInstance() {
        return tNFe;
    }

    public NFE withInformacoesDaNFE(final InformacoesDaNFE infNFe) {
        tNFe.setInfNFe((br.com.caelum.stella.nfe.modelo.InfNFe) ((ObjectCreator) infNFe).getInstance());
        return this;
    }

    public NFE withSignature(final SignatureType signatureType) {
        tNFe.setSignature(signatureType);
        return this;
    }
}