package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSSubstituicaoTributariaImpl<T> implements COFINSSubstituicaoTributaria<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSST cOFINSST;
    private final T parent;

    public COFINSSubstituicaoTributariaImpl(final T parent) {
        this.parent = parent;
        cOFINSST = new br.com.caelum.stella.nfe.modelo.COFINSST();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINSST;
    }

    public COFINSSubstituicaoTributaria<T> withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSST.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSSubstituicaoTributaria<T> withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSST.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSSubstituicaoTributaria<T> withQuantidadeVendida(final BigDecimal string) {
        cOFINSST.setQuantidadeVendida(string.toString());
        return this;
    }

    public COFINSSubstituicaoTributaria<T> withAliquota(final BigDecimal string) {
        cOFINSST.setAliquota(string.toString());
        return this;
    }

    public COFINSSubstituicaoTributaria<T> withValor(final BigDecimal string) {
        cOFINSST.setValor(string.toString());
        return this;
    }
}