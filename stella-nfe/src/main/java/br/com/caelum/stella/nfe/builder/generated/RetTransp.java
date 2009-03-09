package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface RetTransp {
    public RetTransp withVServ(BigDecimal string);

    public RetTransp withVBCRet(BigDecimal string);

    public RetTransp withPICMSRet(BigDecimal aliquota);

    public RetTransp withVICMSRet(BigDecimal string);

    public RetTransp withCFOP(String string);

    public RetTransp withCMunFG(String string);
}