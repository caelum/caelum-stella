package br.com.caelum.stella.nfe.builder.cofins.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.cofins.COFINSSubstituicaoTributaria;
import br.com.caelum.stella.nfe.modelo.COFINSST;

public class COFINSSubstituicaoTributariaImpl implements ObjectCreator, COFINSSubstituicaoTributaria {

    private final COFINSBuilderDelegate<COFINSST> delegate;

    public COFINSSubstituicaoTributariaImpl() {
        delegate = new COFINSBuilderDelegate<COFINSST>(COFINSST.class);
    }

    public COFINSSubstituicaoTributaria withAliquotaEmPercentual(final BigDecimal aliquotaEmPercentual) {
        delegate.withAliquotaEmPercentual(aliquotaEmPercentual);
        return this;
    }

    public COFINSSubstituicaoTributaria withAliquotaEmReais(final BigDecimal aliquotaEmReais) {
        delegate.withAliquotaEmReais(aliquotaEmReais);
        return this;
    }

    public COFINSSubstituicaoTributaria withQuantidadeVendida(final Integer quantidadeVendida) {
        delegate.withQuantidadeVendida(quantidadeVendida);
        return this;
    }

    public COFINSSubstituicaoTributaria withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public COFINSSubstituicaoTributaria withValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        delegate.withValorBaseCalculo(valorBaseCalculo);
        return this;
    }

    public COFINSST getInstance() {
        return delegate.getReference();
    }

}
