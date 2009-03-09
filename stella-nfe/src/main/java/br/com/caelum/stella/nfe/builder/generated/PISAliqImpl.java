package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISAliqImpl implements PISAliq, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISAliq pISAliq;

    public PISAliqImpl() {
        pISAliq = new br.com.caelum.stella.nfe.modelo.PISAliq();
    }

    public br.com.caelum.stella.nfe.modelo.PISAliq getInstance() {
        return pISAliq;
    }

    public PISAliq withCodigoSituacaoTributaria(final String string) {
        pISAliq.setCST(string);
        return this;
    }

    public PISAliq withVBC(final BigDecimal string) {
        pISAliq.setVBC(string.toString());
        return this;
    }

    public PISAliq withPPIS(final BigDecimal aliquota) {
        pISAliq.setPPIS(aliquota.toPlainString());
        return this;
    }

    public PISAliq withVPIS(final BigDecimal string) {
        pISAliq.setVPIS(string.toString());
        return this;
    }
}