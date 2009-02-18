package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISAliqImpl implements PISAliq, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISAliq pISAliq;

    public PISAliqImpl() {
        this.pISAliq = new br.com.caelum.stella.nfe.modelo.PISAliq();
    }

    public br.com.caelum.stella.nfe.modelo.PISAliq getInstance() {
        return this.pISAliq;
    }

    public PISAliq withCodigoSituacaoTributaria(String string) {
        this.pISAliq.setCST(string);
        return this;
    }

    public PISAliq withVBC(String string) {
        this.pISAliq.setVBC(string);
        return this;
    }

    public PISAliq withPPIS(BigDecimal aliquota) {
        this.pISAliq.setPPIS(aliquota.toPlainString());
        return this;
    }

    public PISAliq withVPIS(String string) {
        this.pISAliq.setVPIS(string);
        return this;
    }
}