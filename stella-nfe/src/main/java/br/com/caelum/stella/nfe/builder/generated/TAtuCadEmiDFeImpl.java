package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TAtuCadEmiDFeImpl<T> implements TAtuCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe tAtuCadEmiDFe;
    private final T parent;

    public TAtuCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        tAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tAtuCadEmiDFe;
    }

    public TAtuCadEmiDFe<T> withInfAtuCadEmiDFe(final InfAtuCadEmiDFe<?> infAtuCadEmiDFe) {
        tAtuCadEmiDFe
                     .setInfAtuCadEmiDFe((br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe) ((ObjectCreator) infAtuCadEmiDFe)
                                                                                                                            .getInstance());
        return this;
    }

    public TAtuCadEmiDFe<T> withSignature(final SignatureType signatureType) {
        tAtuCadEmiDFe.setSignature(signatureType);
        return this;
    }

    public TAtuCadEmiDFe<T> withVersao(final String string) {
        tAtuCadEmiDFe.setVersao(string);
        return this;
    }
}