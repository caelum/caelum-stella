package br.com.caelum.stella.nfe.builder.cofins.impl;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.cofins.COFINSNaoTributado;
import br.com.caelum.stella.nfe.builder.cofins.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.COFINSNT;

public class COFINSNaoTributadoImpl implements COFINSNaoTributado, ObjectCreator {

    private final COFINSBuilderDelegate<COFINSNT> delegate;

    public COFINSNaoTributadoImpl(final SituacaoTributaria situacaoTributaria) {
        delegate = new COFINSBuilderDelegate<COFINSNT>(COFINSNT.class, situacaoTributaria);
    }

    public COFINSNT getInstance() {
        return delegate.getReference();
    }

}
