package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetencaoDeTributosFederaisImpl<T> implements RetencaoDeTributosFederais<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTrib retTrib;
    private final T parent;

    public RetencaoDeTributosFederaisImpl(final T parent) {
        this.parent = parent;
        retTrib = new br.com.caelum.stella.nfe.modelo.RetTrib();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.retTrib;
    }

    public RetencaoDeTributosFederais<T> withVRetPIS(final BigDecimal string) {
        retTrib.setVRetPIS(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVRetCOFINS(final BigDecimal string) {
        retTrib.setVRetCOFINS(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVRetCSLL(final BigDecimal string) {
        retTrib.setVRetCSLL(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVBCIRRF(final BigDecimal string) {
        retTrib.setVBCIRRF(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVIRRF(final BigDecimal string) {
        retTrib.setVIRRF(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVBCRetPrev(final BigDecimal string) {
        retTrib.setVBCRetPrev(string.toString());
        return this;
    }

    public RetencaoDeTributosFederais<T> withVRetPrev(final BigDecimal string) {
        retTrib.setVRetPrev(string.toString());
        return this;
    }
}