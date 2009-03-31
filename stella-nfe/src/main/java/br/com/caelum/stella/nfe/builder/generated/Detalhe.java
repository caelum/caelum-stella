package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.Impostos;

public interface Detalhe {
    public Detalhe withProduto(Produto prod);

    public Detalhe withImposto(Impostos impostos);

    public Detalhe withInformacaoAdicionalDoProduto(String string);

    public Detalhe withNumeroDoItemNaNF(String string);
}