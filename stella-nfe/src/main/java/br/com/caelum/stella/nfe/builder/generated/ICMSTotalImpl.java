package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSTotalImpl<T> implements ICMSTotal<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSTot iCMSTot;
    private final T parent;

    public ICMSTotalImpl(final T parent) {
        this.parent = parent;
        iCMSTot = new br.com.caelum.stella.nfe.modelo.ICMSTot();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.iCMSTot;
    }

    public ICMSTotal<T> withValorDaBaseDeCalculo(final BigDecimal string) {
        iCMSTot.setVBC(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotal(final BigDecimal string) {
        iCMSTot.setVICMS(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributaria(final BigDecimal string) {
        iCMSTot.setVBCST(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoICMSSubstituicaoTributaria(final BigDecimal string) {
        iCMSTot.setVST(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDosProdutosEServicos(final BigDecimal string) {
        iCMSTot.setVProd(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoFrete(final BigDecimal string) {
        iCMSTot.setVFrete(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoSeguro(final BigDecimal string) {
        iCMSTot.setVSeg(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDeDesconto(final BigDecimal string) {
        iCMSTot.setVDesc(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoII(final BigDecimal string) {
        iCMSTot.setVII(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoIPI(final BigDecimal string) {
        iCMSTot.setVIPI(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDoPIS(final BigDecimal string) {
        iCMSTot.setVPIS(string.toString());
        return this;
    }

    public ICMSTotal<T> withValor(final BigDecimal string) {
        iCMSTot.setVCOFINS(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDeOutrasDespesas(final BigDecimal string) {
        iCMSTot.setVOutro(string.toString());
        return this;
    }

    public ICMSTotal<T> withValorTotalDaNF(final BigDecimal string) {
        iCMSTot.setVNF(string.toString());
        return this;
    }
}