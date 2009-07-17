package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSSobreCombustiveisImpl<T> implements ICMSSobreCombustiveis<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSComb iCMSComb;
    private final T parent;

    public ICMSSobreCombustiveisImpl(final T parent) {
        this.parent = parent;
        iCMSComb = new br.com.caelum.stella.nfe.modelo.ICMSComb();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.iCMSComb;
    }

    public ICMSSobreCombustiveis<T> withValorDaBaseDeCalculo(final BigDecimal string) {
        iCMSComb.setVBCICMS(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis<T> withValor(final BigDecimal string) {
        iCMSComb.setVICMS(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis<T> withValorDaBaseDeCalculoDaSubstituicaoTributaria(final BigDecimal string) {
        iCMSComb.setVBCICMSST(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis<T> withValorDoICMSDaSubstituicaoTributaria(final BigDecimal string) {
        iCMSComb.setVICMSST(string.toString());
        return this;
    }
}