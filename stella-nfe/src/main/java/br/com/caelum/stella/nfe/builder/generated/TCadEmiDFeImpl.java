package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCadEmiDFeImpl implements TCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TCadEmiDFe tCadEmiDFe;

    public TCadEmiDFeImpl() {
        tCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tCadEmiDFe;
    }

    public TCadEmiDFe withInfCadEmiDFe(final InfCadEmiDFe infCadEmiDFe) {
        tCadEmiDFe
                  .setInfCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfCadEmiDFe) ((ObjectCreator) infCadEmiDFe)
                                                                                                                .getInstance());
        return this;
    }

    public TCadEmiDFe withSignature(final SignatureType signatureType) {
        tCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TCadEmiDFe withVersao(final String string) {
        tCadEmiDFe.setVersao(string);
        return this;
    }
}