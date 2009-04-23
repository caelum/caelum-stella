package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetencaoDeTributosFederaisImpl implements RetencaoDeTributosFederais,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTrib retTrib;

    public RetencaoDeTributosFederaisImpl() {
        retTrib = new br.com.caelum.stella.nfe.modelo.RetTrib();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.retTrib;
    }

    public RetencaoDeTributosFederais withVRetPIS(final BigDecimal string) {
        retTrib.setVRetPIS(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVRetCOFINS(final BigDecimal string) {
        retTrib.setVRetCOFINS(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVRetCSLL(final BigDecimal string) {
        retTrib.setVRetCSLL(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVBCIRRF(final BigDecimal string) {
        retTrib.setVBCIRRF(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVIRRF(final BigDecimal string) {
        retTrib.setVIRRF(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVBCRetPrev(final BigDecimal string) {
        retTrib.setVBCRetPrev(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais withVRetPrev(final BigDecimal string) {
        retTrib.setVRetPrev(string.toString());
        return this;
    }
}