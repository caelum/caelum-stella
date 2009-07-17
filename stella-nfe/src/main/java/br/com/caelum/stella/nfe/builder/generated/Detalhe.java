package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.Impostos;
import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Detalhe<T> extends NFeBuilder<T> {
    public Detalhe<T> withProduto(Produto<?> prod);

    public Detalhe<T> withImposto(Impostos impostos);

    public Detalhe<T> withInformacaoAdicionalDoProduto(String string);

    public Detalhe<T> withNumeroDoItemNaNF(String string);
}