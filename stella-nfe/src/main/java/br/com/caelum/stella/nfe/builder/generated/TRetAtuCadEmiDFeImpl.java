package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetAtuCadEmiDFeImpl implements TRetAtuCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe tRetAtuCadEmiDFe;

    public TRetAtuCadEmiDFeImpl() {
        tRetAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tRetAtuCadEmiDFe;
    }

    public TRetAtuCadEmiDFe withInfRetAtuCadEmiDFe(final InfRetAtuCadEmiDFe infRetAtuCadEmiDFe) {
        tRetAtuCadEmiDFe
                        .setInfRetAtuCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe) ((ObjectCreator) infRetAtuCadEmiDFe)
                                                                                                                                        .getInstance());
        return this;
    }

    public TRetAtuCadEmiDFe withSignature(final SignatureType signatureType) {
        tRetAtuCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TRetAtuCadEmiDFe withVersao(final String string) {
        tRetAtuCadEmiDFe.setVersao(string);
        return this;
    }
}