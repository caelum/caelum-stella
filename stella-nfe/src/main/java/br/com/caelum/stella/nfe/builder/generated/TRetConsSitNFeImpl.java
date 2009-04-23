package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetConsSitNFeImpl implements TRetConsSitNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsSitNFe tRetConsSitNFe;

    public TRetConsSitNFeImpl() {
        tRetConsSitNFe = new br.com.caelum.stella.nfe.modelo.TRetConsSitNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tRetConsSitNFe;
    }

    public TRetConsSitNFe withInfProt(final InfProt infProt) {
        tRetConsSitNFe.setInfProt(infProt);
        return this;
    }

    public TRetConsSitNFe withSignature(final SignatureType signatureType) {
        tRetConsSitNFe.setSignature(signatureType);
        return this;
    }

    public TRetConsSitNFe withVersao(final String string) {
        tRetConsSitNFe.setVersao(string);
        return this;
    }
}