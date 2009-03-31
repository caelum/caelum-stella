package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface Fatura {
    public Fatura withNumeroDaFatura(String string);

    public Fatura withValorOriginal(BigDecimal string);

    public Fatura withValorDeDesconto(BigDecimal string);

    public Fatura withValorLiquido(BigDecimal string);
}