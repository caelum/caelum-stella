package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Combustivel {
    public Combustivel withCProdANP(Integer string);

    public Combustivel withCODIF(BigInteger string);

    public Combustivel withQTemp(BigDecimal string);

    public Combustivel withCIDE(CIDE cIDE);

    public Combustivel withICMSComb(ICMSComb iCMSComb);

    public Combustivel withICMSInter(ICMSInter iCMSInter);

    public Combustivel withICMSCons(ICMSCons iCMSCons);
}