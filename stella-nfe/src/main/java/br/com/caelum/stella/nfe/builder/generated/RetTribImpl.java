package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTribImpl implements RetTrib, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTrib retTrib;

    public RetTribImpl() {
        retTrib = new br.com.caelum.stella.nfe.modelo.RetTrib();
    }

    public br.com.caelum.stella.nfe.modelo.RetTrib getInstance() {
        return retTrib;
    }

    public RetTrib withVRetPIS(final BigDecimal string) {
        retTrib.setVRetPIS(string.toString());
        return this;
    }

    public RetTrib withVRetCOFINS(final BigDecimal string) {
        retTrib.setVRetCOFINS(string.toString());
        return this;
    }

    public RetTrib withVRetCSLL(final BigDecimal string) {
        retTrib.setVRetCSLL(string.toString());
        return this;
    }

    public RetTrib withVBCIRRF(final BigDecimal string) {
        retTrib.setVBCIRRF(string.toString());
        return this;
    }

    public RetTrib withVIRRF(final BigDecimal string) {
        retTrib.setVIRRF(string.toString());
        return this;
    }

    public RetTrib withVBCRetPrev(final BigDecimal string) {
        retTrib.setVBCRetPrev(string.toString());
        return this;
    }

    public RetTrib withVRetPrev(final BigDecimal string) {
        retTrib.setVRetPrev(string.toString());
        return this;
    }
}