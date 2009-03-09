package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSTotImpl implements ICMSTot, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSTot iCMSTot;

    public ICMSTotImpl() {
        iCMSTot = new br.com.caelum.stella.nfe.modelo.ICMSTot();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSTot getInstance() {
        return iCMSTot;
    }

    public ICMSTot withVBC(final BigDecimal string) {
        iCMSTot.setVBC(string.toString());
        return this;
    }

    public ICMSTot withVICMS(final BigDecimal string) {
        iCMSTot.setVICMS(string.toString());
        return this;
    }

    public ICMSTot withVBCST(final BigDecimal string) {
        iCMSTot.setVBCST(string.toString());
        return this;
    }

    public ICMSTot withVST(final BigDecimal string) {
        iCMSTot.setVST(string.toString());
        return this;
    }

    public ICMSTot withVProd(final BigDecimal string) {
        iCMSTot.setVProd(string.toString());
        return this;
    }

    public ICMSTot withVFrete(final BigDecimal string) {
        iCMSTot.setVFrete(string.toString());
        return this;
    }

    public ICMSTot withVSeg(final BigDecimal string) {
        iCMSTot.setVSeg(string.toString());
        return this;
    }

    public ICMSTot withVDesc(final BigDecimal string) {
        iCMSTot.setVDesc(string.toString());
        return this;
    }

    public ICMSTot withVII(final BigDecimal string) {
        iCMSTot.setVII(string.toString());
        return this;
    }

    public ICMSTot withVIPI(final BigDecimal string) {
        iCMSTot.setVIPI(string.toString());
        return this;
    }

    public ICMSTot withVPIS(final BigDecimal string) {
        iCMSTot.setVPIS(string.toString());
        return this;
    }

    public ICMSTot withValor(final BigDecimal string) {
        iCMSTot.setVCOFINS(string.toString());
        return this;
    }

    public ICMSTot withVOutro(final BigDecimal string) {
        iCMSTot.setVOutro(string.toString());
        return this;
    }

    public ICMSTot withVNF(final BigDecimal string) {
        iCMSTot.setVNF(string.toString());
        return this;
    }
}