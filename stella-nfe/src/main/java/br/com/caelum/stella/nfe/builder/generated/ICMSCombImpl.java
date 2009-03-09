package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSCombImpl implements ICMSComb, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSComb iCMSComb;

    public ICMSCombImpl() {
        iCMSComb = new br.com.caelum.stella.nfe.modelo.ICMSComb();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSComb getInstance() {
        return iCMSComb;
    }

    public ICMSComb withVBCICMS(final BigDecimal string) {
        iCMSComb.setVBCICMS(string.toString());
        return this;
    }

    public ICMSComb withVICMS(final BigDecimal string) {
        iCMSComb.setVICMS(string.toString());
        return this;
    }

    public ICMSComb withVBCICMSST(final BigDecimal string) {
        iCMSComb.setVBCICMSST(string.toString());
        return this;
    }

    public ICMSComb withVICMSST(final BigDecimal string) {
        iCMSComb.setVICMSST(string.toString());
        return this;
    }
}