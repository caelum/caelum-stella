package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class CIDESobreCombustiveisImpl implements CIDESobreCombustiveis, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CIDE cIDE;

    public CIDESobreCombustiveisImpl() {
        cIDE = new br.com.caelum.stella.nfe.modelo.CIDE();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.cIDE;
    }

    public CIDESobreCombustiveis withBaseDeCalculo(final BigDecimal string) {
        cIDE.setQBCProd(string.toString());
        return this;
    }

    public CIDESobreCombustiveis withAliquota(final BigDecimal string) {
        cIDE.setVAliqProd(string.toString());
        return this;
    }

    public CIDESobreCombustiveis withValor(final BigDecimal string) {
        cIDE.setVCIDE(string.toString());
        return this;
    }
}