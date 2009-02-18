package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrImpl implements PISOutr, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISOutr pISOutr;

    public PISOutrImpl() {
        this.pISOutr = new br.com.caelum.stella.nfe.modelo.PISOutr();
    }

    public br.com.caelum.stella.nfe.modelo.PISOutr getInstance() {
        return this.pISOutr;
    }

    public PISOutr withCodigoSituacaoTributaria(String string) {
        this.pISOutr.setCST(string);
        return this;
    }

    public PISOutr withVBC(String string) {
        this.pISOutr.setVBC(string);
        return this;
    }

    public PISOutr withPPIS(BigDecimal string) {
        this.pISOutr.setPPIS(string.toPlainString());
        return this;
    }

    public PISOutr withQuantidadeVendida(String string) {
        this.pISOutr.setQBCProd(string);
        return this;
    }

    public PISOutr withAliquota(String string) {
        this.pISOutr.setVAliqProd(string);
        return this;
    }

    public PISOutr withVPIS(String string) {
        this.pISOutr.setVPIS(string);
        return this;
    }
}