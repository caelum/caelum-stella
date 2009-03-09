package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSTImpl implements PISST, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISST pISST;

    public PISSTImpl() {
        pISST = new br.com.caelum.stella.nfe.modelo.PISST();
    }

    public br.com.caelum.stella.nfe.modelo.PISST getInstance() {
        return pISST;
    }

    public PISST withVBC(final BigDecimal string) {
        pISST.setVBC(string.toString());
        return this;
    }

    public PISST withPPIS(final BigDecimal string) {
        pISST.setPPIS(string.toPlainString());
        return this;
    }

    public PISST withQuantidadeVendida(final BigDecimal string) {
        pISST.setQBCProd(string.toString());
        return this;
    }

    public PISST withAliquota(final BigDecimal string) {
        pISST.setVAliqProd(string.toString());
        return this;
    }

    public PISST withVPIS(final BigDecimal string) {
        pISST.setVPIS(string.toString());
        return this;
    }
}