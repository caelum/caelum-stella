package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface COFINSTributadoPelaAliquota<T> extends NFeBuilder<T> {
    public COFINSTributadoPelaAliquota<T> withCodigoSituacaoTributaria(String string);

    public COFINSTributadoPelaAliquota<T> withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public COFINSTributadoPelaAliquota<T> withAliquotaEmPercentual(BigDecimal percentual);

    public COFINSTributadoPelaAliquota<T> withValor(String string);
}