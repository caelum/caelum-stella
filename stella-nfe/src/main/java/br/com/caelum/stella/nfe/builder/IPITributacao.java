package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.enums.ICMSSituacaoTributaria;

public interface IPITributacao<T> extends NFeBuilder<T> {

    public IPITributacao<T> withSituacaoTributaria(ICMSSituacaoTributaria situacao);

    public IPITributacao<T> withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public IPITributacao<T> withAliquota(BigDecimal aliquota);

    public IPITributacao<T> withQuantidadeTotal(BigDecimal quantidadeTotal);

    public IPITributacao<T> withValorPorUnidadeTributavel(BigDecimal valorPorUnidade);

    public IPITributacao<T> withValorDoIPI(BigDecimal valor);
}
