package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PISTributadoPorQuantidade<T> extends NFeBuilder<T> {
    public PISTributadoPorQuantidade<T> withQuantidadeVendida(BigDecimal bigDecimal);

    public PISTributadoPorQuantidade<T> withAliquota(BigDecimal string);

    public PISTributadoPorQuantidade<T> withValorDoPIS(BigDecimal string);
}