package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSTotalImpl implements ICMSTotal, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSTot iCMSTot;

    public ICMSTotalImpl() {
        iCMSTot = new br.com.caelum.stella.nfe.modelo.ICMSTot();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.iCMSTot;
    }

    public ICMSTotal withValorDaBaseDeCalculo(final BigDecimal string) {
        iCMSTot.setVBC(string.toString());
        return this;
    }

    public ICMSTotal withValorTotal(final BigDecimal string) {
        iCMSTot.setVICMS(string.toString());
        return this;
    }

    public ICMSTotal withValorDaBaseDeCalculoDoICMSSubstituicaoTributaria(final BigDecimal string) {
        iCMSTot.setVBCST(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoICMSSubstituicaoTributaria(final BigDecimal string) {
        iCMSTot.setVST(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDosProdutosEServicos(final BigDecimal string) {
        iCMSTot.setVProd(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoFrete(final BigDecimal string) {
        iCMSTot.setVFrete(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoSeguro(final BigDecimal string) {
        iCMSTot.setVSeg(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDeDesconto(final BigDecimal string) {
        iCMSTot.setVDesc(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoII(final BigDecimal string) {
        iCMSTot.setVII(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoIPI(final BigDecimal string) {
        iCMSTot.setVIPI(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDoPIS(final BigDecimal string) {
        iCMSTot.setVPIS(string.toString());
        return this;
    }

    public ICMSTotal withValor(final BigDecimal string) {
        iCMSTot.setVCOFINS(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDeOutrasDespesas(final BigDecimal string) {
        iCMSTot.setVOutro(string.toString());
        return this;
    }

    public ICMSTotal withValorTotalDaNF(final BigDecimal string) {
        iCMSTot.setVNF(string.toString());
        return this;
    }
}