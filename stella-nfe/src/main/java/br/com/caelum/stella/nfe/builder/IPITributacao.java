package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;

public interface IPITributacao {

    public IPITributacao withSituacaoTributaria(SituacaoTributaria situacao);

    public IPITributacao withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public IPITributacao withAliquota(BigDecimal aliquota);

    public IPITributacao withQuantidadeTotal(BigDecimal quantidadeTotal);

    public IPITributacao withValorPorUnidadeTributavel(BigDecimal valorPorUnidade);

    public IPITributacao withValorDoIPI(BigDecimal valor);
}
