package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class FaturaImpl<T> implements Fatura<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Fat fat;
    private final T parent;

    public FaturaImpl(final T parent) {
        this.parent = parent;
        fat = new br.com.caelum.stella.nfe.modelo.Fat();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.fat;
    }

    public Fatura<T> withNumeroDaFatura(final String string) {
        fat.setNFat(string);
        return this;
    }

    public Fatura<T> withValorOriginal(final BigDecimal string) {
        fat.setVOrig(string.toString());
        return this;
    }

    public Fatura<T> withValorDeDesconto(final BigDecimal string) {
        fat.setVDesc(string.toString());
        return this;
    }

    public Fatura<T> withValorLiquido(final BigDecimal string) {
        fat.setVLiq(string.toString());
        return this;
    }
}