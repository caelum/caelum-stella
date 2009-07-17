package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSTributadoPelaQuantidadeImpl<T> implements COFINSTributadoPelaQuantidade<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSQtde cOFINSQtde;
    private final T parent;

    public COFINSTributadoPelaQuantidadeImpl(final T parent) {
        this.parent = parent;
        cOFINSQtde = new br.com.caelum.stella.nfe.modelo.COFINSQtde();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINSQtde;
    }

    public COFINSTributadoPelaQuantidade<T> withCodigoSituacaoTributaria(final String string) {
        cOFINSQtde.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSTributadoPelaQuantidade<T> withQuantidadeVendida(final BigDecimal string) {
        cOFINSQtde.setQuantidadeVendida(string.toString());
        return this;
    }

    public COFINSTributadoPelaQuantidade<T> withAliquota(final BigDecimal string) {
        cOFINSQtde.setAliquota(string.toString());
        return this;
    }

    public COFINSTributadoPelaQuantidade<T> withValor(final BigDecimal string) {
        cOFINSQtde.setValor(string.toString());
        return this;
    }
}