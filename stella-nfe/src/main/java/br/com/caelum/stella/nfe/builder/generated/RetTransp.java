package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface RetTransp {
    public RetTransp withVServ(String string);

    public RetTransp withVBCRet(String string);

    public RetTransp withPICMSRet(BigDecimal aliquota);

    public RetTransp withVICMSRet(String string);

    public RetTransp withCFOP(String string);

    public RetTransp withCMunFG(String string);
}