package br.com.caelum.stella.nfe.builder.cofins.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.cofins.COFINSTributadoPorQuantidade;
import br.com.caelum.stella.nfe.builder.cofins.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.COFINSQtde;

public class COFINSTributadoPorQuantidadeImpl implements COFINSTributadoPorQuantidade, ObjectCreator {

    private final COFINSBuilderDelegate<COFINSQtde> delegate;

    public COFINSTributadoPorQuantidadeImpl() {
        delegate = new COFINSBuilderDelegate<COFINSQtde>(COFINSQtde.class,
                SituacaoTributaria.QUANTIDADE_VENDIDA_VERSUS_ALIQUOTA_POR_UNIDADE_DE_PRODUTO);
    }

    public COFINSTributadoPorQuantidade withAliquotaEmReais(final BigDecimal aliquotaEmReais) {
        delegate.withAliquotaEmReais(aliquotaEmReais);
        return this;
    }

    public COFINSTributadoPorQuantidade withQuantidadeVendida(final Integer quantidadeVendida) {
        delegate.withQuantidadeVendida(quantidadeVendida);
        return this;
    }

    public COFINSTributadoPorQuantidade withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public COFINSQtde getInstance() {
        return delegate.getReference();
    }
}
