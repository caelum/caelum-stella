package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrasOperacoesImpl<T> implements PISOutrasOperacoes<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISOutr pISOutr;
    private final T parent;

    public PISOutrasOperacoesImpl(final T parent) {
        this.parent = parent;
        pISOutr = new br.com.caelum.stella.nfe.modelo.PISOutr();
        pISOutr.setCST("99");
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.pISOutr;
    }

    public PISOutrasOperacoes<T> withValorDaBaseDeCalculo(final BigDecimal string) {
        pISOutr.setVBC(string.toString());
        return this;
    }

    public PISOutrasOperacoes<T> withAliquota(final BigDecimal string) {
        pISOutr.setPPIS(string.toString());
        return this;
    }

    public PISOutrasOperacoes<T> withQuantidadeVendida(final BigDecimal string) {
        pISOutr.setQBCProd(string.toString());
        return this;
    }

    public PISOutrasOperacoes<T> withAliquotaDoProduto(final BigDecimal string) {
        pISOutr.setVAliqProd(string.toString());
        return this;
    }

    public PISOutrasOperacoes<T> withValor(final BigDecimal string) {
        pISOutr.setVPIS(string.toString());
        return this;
    }
}