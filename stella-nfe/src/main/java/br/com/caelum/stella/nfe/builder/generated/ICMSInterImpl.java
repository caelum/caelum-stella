package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSInterImpl implements ICMSInter, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSInter iCMSInter;

    public ICMSInterImpl() {
        iCMSInter = new br.com.caelum.stella.nfe.modelo.ICMSInter();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSInter getInstance() {
        return iCMSInter;
    }

    public ICMSInter withVBCICMSSTDest(final BigDecimal string) {
        iCMSInter.setVBCICMSSTDest(string.toString());
        return this;
    }

    public ICMSInter withVICMSSTDest(final BigDecimal string) {
        iCMSInter.setVICMSSTDest(string.toString());
        return this;
    }
}