package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSubstituicaoTributariaImpl<T> implements PISSubstituicaoTributaria<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISST pISST;
    private final T parent;

    public PISSubstituicaoTributariaImpl(final T parent) {
        this.parent = parent;
        pISST = new br.com.caelum.stella.nfe.modelo.PISST();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.pISST;
    }

    public PISSubstituicaoTributaria<T> withValorDaBaseDeCalculo(final BigDecimal string) {
        pISST.setVBC(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria<T> withAliquotaDaSubstituicaoTributaria(final BigDecimal string) {
        pISST.setPPIS(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria<T> withQuantidadeVendida(final BigDecimal string) {
        pISST.setQBCProd(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria<T> withAliquota(final BigDecimal string) {
        pISST.setVAliqProd(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria<T> withValor(final BigDecimal string) {
        pISST.setVPIS(string.toString());
        return this;
    }
}