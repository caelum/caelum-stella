package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISTributadoPelaAliquotaImpl<T> implements PISTributadoPelaAliquota<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISAliq pISAliq;
    private final T parent;

    public PISTributadoPelaAliquotaImpl(final T parent) {
        this.parent = parent;
        pISAliq = new br.com.caelum.stella.nfe.modelo.PISAliq();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.pISAliq;
    }

    public PISTributadoPelaAliquota<T> withCodigoSituacaoTributaria(final String string) {
        pISAliq.setCST(string);
        return this;
    }

    public PISTributadoPelaAliquota<T> withValorDaBaseDeCalculo(final BigDecimal string) {
        pISAliq.setVBC(string.toString());
        return this;
    }

    public PISTributadoPelaAliquota<T> withAliquotaDoPIS(final BigDecimal aliquota) {
        pISAliq.setPPIS(aliquota.toPlainString());
        return this;
    }

    public PISTributadoPelaAliquota<T> withValorDoPIS(final BigDecimal string) {
        pISAliq.setVPIS(string.toString());
        return this;
    }
}