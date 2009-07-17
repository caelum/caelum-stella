package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfAtuCadEmiDFeImpl<T> implements InfAtuCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe infAtuCadEmiDFe;
    private final T parent;

    public InfAtuCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        infAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) infAtuCadEmiDFe;
    }

    public InfAtuCadEmiDFe<T> withUF(final TUf tUf) {
        infAtuCadEmiDFe.setUF(tUf);
        return this;
    }

    public InfAtuCadEmiDFe<T> withInclui(final TEmissor<?> tEmissor) {
        infAtuCadEmiDFe.setInclui((br.com.caelum.stella.nfe.modelo.TEmissor) ((ObjectCreator) tEmissor).getInstance());
        return this;
    }

    public InfAtuCadEmiDFe<T> withExclui(final Exclui<?> exclui) {
        infAtuCadEmiDFe.setExclui((br.com.caelum.stella.nfe.modelo.Exclui) ((ObjectCreator) exclui).getInstance());
        return this;
    }

    public InfAtuCadEmiDFe<T> withId(final String string) {
        infAtuCadEmiDFe.setId(string);
        return this;
    }
}