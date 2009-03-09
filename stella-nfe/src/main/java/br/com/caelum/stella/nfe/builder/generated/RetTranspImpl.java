package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTranspImpl implements RetTransp, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTransp retTransp;

    public RetTranspImpl() {
        retTransp = new br.com.caelum.stella.nfe.modelo.RetTransp();
    }

    public br.com.caelum.stella.nfe.modelo.RetTransp getInstance() {
        return retTransp;
    }

    public RetTransp withVServ(final BigDecimal string) {
        retTransp.setVServ(string.toString());
        return this;
    }

    public RetTransp withVBCRet(final BigDecimal string) {
        retTransp.setVBCRet(string.toString());
        return this;
    }

    public RetTransp withPICMSRet(final BigDecimal aliquota) {
        retTransp.setPICMSRet(aliquota.toPlainString());
        return this;
    }

    public RetTransp withVICMSRet(final BigDecimal string) {
        retTransp.setVICMSRet(string.toString());
        return this;
    }

    public RetTransp withCFOP(final String string) {
        retTransp.setCFOP(string);
        return this;
    }

    public RetTransp withCMunFG(final String string) {
        retTransp.setCMunFG(string);
        return this;
    }
}