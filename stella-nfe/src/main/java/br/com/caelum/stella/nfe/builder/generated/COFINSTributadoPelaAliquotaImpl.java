package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSTributadoPelaAliquotaImpl<T> implements COFINSTributadoPelaAliquota<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSAliq cOFINSAliq;
    private final T parent;

    public COFINSTributadoPelaAliquotaImpl(final T parent) {
        this.parent = parent;
        cOFINSAliq = new br.com.caelum.stella.nfe.modelo.COFINSAliq();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINSAliq;
    }

    public COFINSTributadoPelaAliquota<T> withCodigoSituacaoTributaria(final String string) {
        cOFINSAliq.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSTributadoPelaAliquota<T> withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSAliq.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSTributadoPelaAliquota<T> withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSAliq.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSTributadoPelaAliquota<T> withValor(final String string) {
        cOFINSAliq.setValor(string);
        return this;
    }
}