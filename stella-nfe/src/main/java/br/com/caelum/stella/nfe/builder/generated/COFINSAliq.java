package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface COFINSAliq {
    public COFINSAliq withCodigoSituacaoTributaria(String string);

    public COFINSAliq withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public COFINSAliq withAliquotaEmPercentual(BigDecimal percentual);

    public COFINSAliq withValor(String string);
}