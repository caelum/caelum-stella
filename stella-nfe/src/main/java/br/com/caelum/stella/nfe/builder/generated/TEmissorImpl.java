package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEmissorImpl implements TEmissor, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEmissor tEmissor;

    public TEmissorImpl() {
        tEmissor = new br.com.caelum.stella.nfe.modelo.TEmissor();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tEmissor;
    }

    public TEmissor withUF(final TUf tUf) {
        tEmissor.setUF(tUf);
        return this;
    }

    public TEmissor withCNPJ(final String string) {
        tEmissor.setCNPJ(string);
        return this;
    }

    public TEmissor withCNPJMatriz(final String string) {
        tEmissor.setCNPJMatriz(string);
        return this;
    }

    public TEmissor withIE(final String string) {
        tEmissor.setIE(string);
        return this;
    }

    public TEmissor withDFe(final List<DFe> listDFe) {
        List<br.com.caelum.stella.nfe.modelo.DFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.DFe>();
        for (DFe fe : listDFe) {
            list.add((br.com.caelum.stella.nfe.modelo.DFe) ((ObjectCreator) fe).getInstance());
        }
        tEmissor.setDFe(list);
        return this;
    }
}