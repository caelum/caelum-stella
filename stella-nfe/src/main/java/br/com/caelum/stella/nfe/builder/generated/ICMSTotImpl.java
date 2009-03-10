package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSTotImpl implements ICMSTotal, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSTot iCMSTot;

    public ICMSTotImpl() {
        iCMSTot = new br.com.caelum.stella.nfe.modelo.ICMSTot();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSTot getInstance() {
        return iCMSTot;
    }

    public ICMSTotal withVBC(final BigDecimal string) {
        iCMSTot.setVBC(string.toString());
        return this;
    }

    public ICMSTotal withVICMS(final BigDecimal string) {
        iCMSTot.setVICMS(string.toString());
        return this;
    }

    public ICMSTotal withVBCST(final BigDecimal string) {
        iCMSTot.setVBCST(string.toString());
        return this;
    }

    public ICMSTotal withVST(final BigDecimal string) {
        iCMSTot.setVST(string.toString());
        return this;
    }

    public ICMSTotal withVProd(final BigDecimal string) {
        iCMSTot.setVProd(string.toString());
        return this;
    }

    public ICMSTotal withVFrete(final BigDecimal string) {
        iCMSTot.setVFrete(string.toString());
        return this;
    }

    public ICMSTotal withVSeg(final BigDecimal string) {
        iCMSTot.setVSeg(string.toString());
        return this;
    }

    public ICMSTotal withVDesc(final BigDecimal string) {
        iCMSTot.setVDesc(string.toString());
        return this;
    }

    public ICMSTotal withVII(final BigDecimal string) {
        iCMSTot.setVII(string.toString());
        return this;
    }

    public ICMSTotal withVIPI(final BigDecimal string) {
        iCMSTot.setVIPI(string.toString());
        return this;
    }

    public ICMSTotal withVPIS(final BigDecimal string) {
        iCMSTot.setVPIS(string.toString());
        return this;
    }

    public ICMSTotal withValor(final BigDecimal string) {
        iCMSTot.setVCOFINS(string.toString());
        return this;
    }

    public ICMSTotal withVOutro(final BigDecimal string) {
        iCMSTot.setVOutro(string.toString());
        return this;
    }

    public ICMSTotal withVNF(final BigDecimal string) {
        iCMSTot.setVNF(string.toString());
        return this;
    }
}