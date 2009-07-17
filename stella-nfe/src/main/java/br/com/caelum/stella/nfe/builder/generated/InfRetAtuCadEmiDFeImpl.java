package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfRetAtuCadEmiDFeImpl<T> implements InfRetAtuCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe infRetAtuCadEmiDFe;
    private final T parent;

    public InfRetAtuCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        this.infRetAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.infRetAtuCadEmiDFe;
    }

    public InfRetAtuCadEmiDFe<T> withUF(final TUf tUf) {
        this.infRetAtuCadEmiDFe.setUF(tUf);
        return this;
    }

    public InfRetAtuCadEmiDFe<T> withCNPJ(final Object object) {
        this.infRetAtuCadEmiDFe.setCNPJ(object);
        return this;
    }

    public InfRetAtuCadEmiDFe<T> withOpe(final String string) {
        this.infRetAtuCadEmiDFe.setOpe(string);
        return this;
    }

    public InfRetAtuCadEmiDFe<T> withResOpe(final String string) {
        this.infRetAtuCadEmiDFe.setResOpe(string);
        return this;
    }

    public InfRetAtuCadEmiDFe<T> withId(final String string) {
        this.infRetAtuCadEmiDFe.setId(string);
        return this;
    }
}