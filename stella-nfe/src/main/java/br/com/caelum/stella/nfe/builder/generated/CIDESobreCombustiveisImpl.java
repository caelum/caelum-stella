package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class CIDESobreCombustiveisImpl<T> implements CIDESobreCombustiveis<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CIDE cIDE;
    private final T parent;

    public CIDESobreCombustiveisImpl(final T parent) {
        this.parent = parent;
        cIDE = new br.com.caelum.stella.nfe.modelo.CIDE();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cIDE;
    }

    public CIDESobreCombustiveis<T> withBaseDeCalculo(final BigDecimal string) {
        cIDE.setQBCProd(string.toString());
        return this;
    }

    public CIDESobreCombustiveis<T> withAliquota(final BigDecimal string) {
        cIDE.setVAliqProd(string.toString());
        return this;
    }

    public CIDESobreCombustiveis<T> withValor(final BigDecimal string) {
        cIDE.setVCIDE(string.toString());
        return this;
    }
}