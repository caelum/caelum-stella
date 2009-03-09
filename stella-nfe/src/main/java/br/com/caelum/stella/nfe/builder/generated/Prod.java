package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface Prod {
    public Prod withCProd(String string);

    public Prod withCEAN(String string);

    public Prod withXProd(String string);

    public Prod withNCM(String string);

    public Prod withEXTIPI(String string);

    public Prod withGenero(String string);

    public Prod withCFOP(String string);

    public Prod withUCom(String string);

    public Prod withQCom(BigDecimal string);

    public Prod withVUnCom(BigDecimal string);

    public Prod withVProd(BigDecimal string);

    public Prod withCEANTrib(String string);

    public Prod withUTrib(String string);

    public Prod withQTrib(BigDecimal string);

    public Prod withVUnTrib(BigDecimal string);

    public Prod withVFrete(BigDecimal string);

    public Prod withVSeg(BigDecimal string);

    public Prod withVDesc(BigDecimal string);

    public Prod withDI(DI... di);

    public Prod withVeicProd(VeicProd veicProd);

    public Prod withMed(Med... meds);

    public Prod withArma(Armamento... armas);

    public Prod withComb(Comb comb);
}