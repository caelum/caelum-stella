package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface PISAliq {
    public PISAliq withCodigoSituacaoTributaria(String string);

    public PISAliq withVBC(String string);

    public PISAliq withPPIS(BigDecimal aliquota);

    public PISAliq withVPIS(String string);
}