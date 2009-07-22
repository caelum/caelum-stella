package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public final class ExcluiImpl<T> implements Exclui<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Exclui exclui;
    private final T parent;

    public ExcluiImpl(final T parent) {
        this.parent = parent;
        this.exclui = new br.com.caelum.stella.nfe.modelo.Exclui();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.exclui;
    }

    public Exclui<T> withUF(final TUf tUf) {
        this.exclui.setUF(tUf);
        return this;
    }

    public Exclui<T> withCNPJ(final CNPJ object) {
        this.exclui.setCNPJ(object);
        return this;
    }
}