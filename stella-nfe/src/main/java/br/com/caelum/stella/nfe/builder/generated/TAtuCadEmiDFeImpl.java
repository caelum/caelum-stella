package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TAtuCadEmiDFeImpl implements TAtuCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe tAtuCadEmiDFe;

    public TAtuCadEmiDFeImpl() {
        tAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tAtuCadEmiDFe;
    }

    public TAtuCadEmiDFe withInfAtuCadEmiDFe(final InfAtuCadEmiDFe infAtuCadEmiDFe) {
        tAtuCadEmiDFe
                     .setInfAtuCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe) ((ObjectCreator) infAtuCadEmiDFe)
                                                                                                                            .getInstance());
        return this;
    }

    public TAtuCadEmiDFe withSignature(final SignatureType signatureType) {
        tAtuCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TAtuCadEmiDFe withVersao(final String string) {
        tAtuCadEmiDFe.setVersao(string);
        return this;
    }
}