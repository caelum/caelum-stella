package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class CIDEImpl implements CIDE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CIDE cIDE;

    public CIDEImpl() {
        cIDE = new br.com.caelum.stella.nfe.modelo.CIDE();
    }

    public br.com.caelum.stella.nfe.modelo.CIDE getInstance() {
        return cIDE;
    }

    public CIDE withBC(final BigDecimal string) {
        cIDE.setQBCProd(string.toString());
        return this;
    }

    public CIDE withAliquota(final BigDecimal string) {
        cIDE.setVAliqProd(string.toString());
        return this;
    }

    public CIDE withValor(final BigDecimal string) {
        cIDE.setVCIDE(string.toString());
        return this;
    }
}