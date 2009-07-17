package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface COFINSTributadoPelaQuantidade<T> extends NFeBuilder<T> {
    public COFINSTributadoPelaQuantidade<T> withCodigoSituacaoTributaria(String string);

    public COFINSTributadoPelaQuantidade<T> withQuantidadeVendida(BigDecimal string);

    public COFINSTributadoPelaQuantidade<T> withAliquota(BigDecimal string);

    public COFINSTributadoPelaQuantidade<T> withValor(BigDecimal string);
}