package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Comb {
    public Comb withCProdANP(Integer string);

    public Comb withCODIF(BigInteger string);

    public Comb withQTemp(BigDecimal string);

    public Comb withCIDE(CIDE cIDE);

    public Comb withICMSComb(ICMSComb iCMSComb);

    public Comb withICMSInter(ICMSInter iCMSInter);

    public Comb withICMSCons(ICMSCons iCMSCons);
}