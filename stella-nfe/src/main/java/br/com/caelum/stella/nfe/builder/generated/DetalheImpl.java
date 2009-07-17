package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetalheImpl<T> implements Detalhe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Det det;
    private final T parent;

    public DetalheImpl(final T parent) {
        this.parent = parent;
        det = new br.com.caelum.stella.nfe.modelo.Det();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.det;
    }

    public Detalhe<T> withProduto(final Produto<?> prod) {
        det.setProd((br.com.caelum.stella.nfe.modelo.Prod) ((ObjectCreator) prod).getInstance());
        return this;
    }

    public Detalhe<T> withImposto(final Impostos imposto) {
        det.setImposto((br.com.caelum.stella.nfe.modelo.Imposto) ((ObjectCreator) imposto).getInstance());
        return this;
    }

    public Detalhe<T> withInformacaoAdicionalDoProduto(final String string) {
        det.setInfAdProd(string);
        return this;
    }

    public Detalhe<T> withNumeroDoItemNaNF(final String string) {
        det.setNItem(string);
        return this;
    }
}