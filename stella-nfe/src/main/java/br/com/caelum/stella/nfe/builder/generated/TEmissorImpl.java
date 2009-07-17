package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEmissorImpl<T> implements TEmissor<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEmissor tEmissor;
    private final T parent;

    public TEmissorImpl(final T parent) {
        this.parent = parent;
        tEmissor = new br.com.caelum.stella.nfe.modelo.TEmissor();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tEmissor;
    }

    public TEmissor<T> withUF(final TUf tUf) {
        tEmissor.setUF(tUf);
        return this;
    }

    public TEmissor<T> withCNPJ(final String string) {
        tEmissor.setCNPJ(string);
        return this;
    }

    public TEmissor<T> withCNPJMatriz(final String string) {
        tEmissor.setCNPJMatriz(string);
        return this;
    }

    public TEmissor<T> withIE(final String string) {
        tEmissor.setIE(string);
        return this;
    }

    public TEmissor<T> withDFe(final List<DFe<?>> listDFe) {
        List<br.com.caelum.stella.nfe.modelo.DFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.DFe>();
        for (DFe<?> fe : listDFe) {
            list.add((br.com.caelum.stella.nfe.modelo.DFe) ((ObjectCreator) fe).getInstance());
        }
        tEmissor.setDFe(list);
        return this;
    }
}