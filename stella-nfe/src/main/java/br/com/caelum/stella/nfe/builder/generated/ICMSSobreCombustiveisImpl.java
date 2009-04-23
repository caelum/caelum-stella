package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSSobreCombustiveisImpl implements ICMSSobreCombustiveis, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSComb iCMSComb;

    public ICMSSobreCombustiveisImpl() {
        iCMSComb = new br.com.caelum.stella.nfe.modelo.ICMSComb();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.iCMSComb;
    }

    public ICMSSobreCombustiveis withValorDaBaseDeCalculo(final BigDecimal string) {
        iCMSComb.setVBCICMS(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis withValor(final BigDecimal string) {
        iCMSComb.setVICMS(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis withValorDaBaseDeCalculoDaSubstituicaoTributaria(final BigDecimal string) {
        iCMSComb.setVBCICMSST(string.toString());
        return this;
    }

    public ICMSSobreCombustiveis withValorDoICMSDaSubstituicaoTributaria(final BigDecimal string) {
        iCMSComb.setVICMSST(string.toString());
        return this;
    }
}