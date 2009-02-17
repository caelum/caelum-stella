package br.com.caelum.stella.nfe.builder.cofins.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.cofins.COFINSOutrasOperacoes;
import br.com.caelum.stella.nfe.builder.cofins.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.COFINSOutr;

public class COFINSOutrasOperacoesImpl implements COFINSOutrasOperacoes, ObjectCreator {

    private final COFINSBuilderDelegate<COFINSOutr> delegate;

    public COFINSOutrasOperacoesImpl() {
        delegate = new COFINSBuilderDelegate<COFINSOutr>(COFINSOutr.class, SituacaoTributaria.OUTRAS_OPERACOES);
    }

    public COFINSOutrasOperacoes withAliquotaEmPercentual(final BigDecimal aliquotaEmPercentual) {
        delegate.withAliquotaEmPercentual(aliquotaEmPercentual);
        return this;
    }

    public COFINSOutrasOperacoes withAliquotaEmReais(final BigDecimal aliquotaEmReais) {
        delegate.withAliquotaEmReais(aliquotaEmReais);
        return this;
    }

    public COFINSOutrasOperacoes withQuantidadeVendida(final Integer quantidadeVendida) {
        delegate.withQuantidadeVendida(quantidadeVendida);
        return this;
    }

    public COFINSOutrasOperacoes withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public COFINSOutrasOperacoes withValorDaBaseDeCalculo(final BigDecimal valorDaBaseDeCalculo) {
        delegate.withValorDaBaseDeCalculo(valorDaBaseDeCalculo);
        return this;
    }

    public COFINSOutr getInstance() {
        return delegate.getReference();
    }

}
