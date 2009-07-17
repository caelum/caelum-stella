package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface COFINSSubstituicaoTributaria<T> extends NFeBuilder<T> {
    public COFINSSubstituicaoTributaria<T> withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public COFINSSubstituicaoTributaria<T> withAliquotaEmPercentual(BigDecimal percentual);

    public COFINSSubstituicaoTributaria<T> withQuantidadeVendida(BigDecimal string);

    public COFINSSubstituicaoTributaria<T> withAliquota(BigDecimal string);

    public COFINSSubstituicaoTributaria<T> withValor(BigDecimal string);
}