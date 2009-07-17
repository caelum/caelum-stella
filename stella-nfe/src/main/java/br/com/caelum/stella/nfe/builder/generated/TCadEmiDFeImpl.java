package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCadEmiDFeImpl<T> implements TCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TCadEmiDFe tCadEmiDFe;
    private final T parent;

    public TCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        tCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tCadEmiDFe;
    }

    public TCadEmiDFe<T> withInfCadEmiDFe(final InfCadEmiDFe<?> infCadEmiDFe) {
        tCadEmiDFe
                  .setInfCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfCadEmiDFe) ((ObjectCreator) infCadEmiDFe)
                                                                                                                .getInstance());
        return this;
    }

    public TCadEmiDFe<T> withSignature(final SignatureType signatureType) {
        tCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TCadEmiDFe<T> withVersao(final String string) {
        tCadEmiDFe.setVersao(string);
        return this;
    }
}