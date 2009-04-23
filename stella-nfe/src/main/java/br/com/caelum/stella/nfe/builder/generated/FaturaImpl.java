package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class FaturaImpl implements Fatura, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Fat fat;

    public FaturaImpl() {
        fat = new br.com.caelum.stella.nfe.modelo.Fat();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.fat;
    }

    public Fatura withNumeroDaFatura(final String string) {
        fat.setNFat(string);
        return this;
    }

    public Fatura withValorOriginal(final BigDecimal string) {
        fat.setVOrig(string.toString());
        return this;
    }

    public Fatura withValorDeDesconto(final BigDecimal string) {
        fat.setVDesc(string.toString());
        return this;
    }

    public Fatura withValorLiquido(final BigDecimal string) {
        fat.setVLiq(string.toString());
        return this;
    }
}