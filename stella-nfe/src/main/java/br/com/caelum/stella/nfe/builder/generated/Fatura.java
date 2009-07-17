package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Fatura<T> extends NFeBuilder<T> {
    public Fatura<T> withNumeroDaFatura(String string);

    public Fatura<T> withValorOriginal(BigDecimal string);

    public Fatura<T> withValorDeDesconto(BigDecimal string);

    public Fatura<T> withValorLiquido(BigDecimal string);
}