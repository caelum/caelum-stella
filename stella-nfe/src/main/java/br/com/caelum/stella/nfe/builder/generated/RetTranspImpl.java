package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTranspImpl implements RetTransp, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTransp retTransp;

    public RetTranspImpl() {
        this.retTransp = new br.com.caelum.stella.nfe.modelo.RetTransp();
    }

    public br.com.caelum.stella.nfe.modelo.RetTransp getInstance() {
        return this.retTransp;
    }

    public RetTransp withVServ(String string) {
        this.retTransp.setVServ(string);
        return this;
    }

    public RetTransp withVBCRet(String string) {
        this.retTransp.setVBCRet(string);
        return this;
    }

    public RetTransp withPICMSRet(BigDecimal aliquota) {
        this.retTransp.setPICMSRet(aliquota.toPlainString());
        return this;
    }

    public RetTransp withVICMSRet(String string) {
        this.retTransp.setVICMSRet(string);
        return this;
    }

    public RetTransp withCFOP(String string) {
        this.retTransp.setCFOP(string);
        return this;
    }

    public RetTransp withCMunFG(String string) {
        this.retTransp.setCMunFG(string);
        return this;
    }
}