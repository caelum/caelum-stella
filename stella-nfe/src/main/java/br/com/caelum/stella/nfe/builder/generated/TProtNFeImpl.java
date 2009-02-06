package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TProtNFeImpl implements TProtNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProtNFe tProtNFe;

    public TProtNFeImpl() {
        tProtNFe = new br.com.caelum.stella.nfe.modelo.TProtNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TProtNFe getInstance() {
        return tProtNFe;
    }

    public TProtNFe withInfProt(final InfProt infProt) {
        tProtNFe.setInfProt((br.com.caelum.stella.nfe.modelo.InfProt) ((ObjectCreator) infProt).getInstance());
        return this;
    }

    public TProtNFe withSignature(final SignatureType signatureType) {
        tProtNFe.setSignature(signatureType);
        return this;
    }

    public TProtNFe withVersao(final String string) {
        tProtNFe.setVersao(string);
        return this;
    }
}