package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class FatImpl implements Fat, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Fat fat;

    public FatImpl() {
        fat = new br.com.caelum.stella.nfe.modelo.Fat();
    }

    public br.com.caelum.stella.nfe.modelo.Fat getInstance() {
        return fat;
    }

    public Fat withNFat(final String string) {
        fat.setNFat(string);
        return this;
    }

    public Fat withVOrig(final BigDecimal string) {
        fat.setVOrig(string.toString());
        return this;
    }

    public Fat withVDesc(final BigDecimal string) {
        fat.setVDesc(string.toString());
        return this;
    }

    public Fat withVLiq(final BigDecimal string) {
        fat.setVLiq(string.toString());
        return this;
    }
}