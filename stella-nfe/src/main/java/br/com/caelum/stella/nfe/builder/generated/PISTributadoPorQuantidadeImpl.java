package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISTributadoPorQuantidadeImpl<T> implements PISTributadoPorQuantidade<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISQtde pISQtde;
    private final T parent;

    public PISTributadoPorQuantidadeImpl(final T parent) {
        this.parent = parent;
        pISQtde = new br.com.caelum.stella.nfe.modelo.PISQtde();
        pISQtde.setCST("03");
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.pISQtde;
    }

    public PISTributadoPorQuantidade<T> withQuantidadeVendida(final BigDecimal string) {
        pISQtde.setQBCProd(string.toString());
        return this;
    }

    public PISTributadoPorQuantidade<T> withAliquota(final BigDecimal string) {
        pISQtde.setVAliqProd(string.toString());
        return this;
    }

    public PISTributadoPorQuantidade<T> withValorDoPIS(final BigDecimal string) {
        pISQtde.setVPIS(string.toString());
        return this;
    }
}