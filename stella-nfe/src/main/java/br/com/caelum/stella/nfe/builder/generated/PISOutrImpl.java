package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrImpl implements PISOutr, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISOutr pISOutr;

    public PISOutrImpl() {
        pISOutr = new br.com.caelum.stella.nfe.modelo.PISOutr();
    }

    public br.com.caelum.stella.nfe.modelo.PISOutr getInstance() {
        return pISOutr;
    }

    public PISOutr withCodigoSituacaoTributaria(final String string) {
        pISOutr.setCST(string);
        return this;
    }

    public PISOutr withVBC(final BigDecimal string) {
        pISOutr.setVBC(string.toString());
        return this;
    }

    public PISOutr withPPIS(final BigDecimal string) {
        pISOutr.setPPIS(string.toString());
        return this;
    }

    public PISOutr withQuantidadeVendida(final BigDecimal string) {
        pISOutr.setQBCProd(string.toString());
        return this;
    }

    public PISOutr withAliquota(final BigDecimal string) {
        pISOutr.setVAliqProd(string.toString());
        return this;
    }

    public PISOutr withVPIS(final BigDecimal string) {
        pISOutr.setVPIS(string.toString());
        return this;
    }
}