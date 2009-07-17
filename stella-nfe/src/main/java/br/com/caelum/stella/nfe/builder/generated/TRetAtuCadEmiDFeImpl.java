package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetAtuCadEmiDFeImpl<T> implements TRetAtuCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe tRetAtuCadEmiDFe;
    private final T parent;

    public TRetAtuCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        tRetAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tRetAtuCadEmiDFe;
    }

    public TRetAtuCadEmiDFe<T> withInfRetAtuCadEmiDFe(final InfRetAtuCadEmiDFe<?> infRetAtuCadEmiDFe) {
        tRetAtuCadEmiDFe
                        .setInfRetAtuCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe) ((ObjectCreator) infRetAtuCadEmiDFe)
                                                                                                                                        .getInstance());
        return this;
    }

    public TRetAtuCadEmiDFe<T> withSignature(final SignatureType signatureType) {
        tRetAtuCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TRetAtuCadEmiDFe<T> withVersao(final String string) {
        tRetAtuCadEmiDFe.setVersao(string);
        return this;
    }
}