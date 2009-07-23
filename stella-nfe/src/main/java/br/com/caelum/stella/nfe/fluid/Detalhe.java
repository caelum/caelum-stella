package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Det.class)
public interface Detalhe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("prod")
    Produto<Detalhe<T>> withProduto();

    @net.vidageek.fluid.annotations.FluidField("imposto")
    Imposto<Detalhe<T>> withImposto();

    @net.vidageek.fluid.annotations.FluidField("infAdProd")
    Detalhe<T> withInformacaoAdicionalDoProduto(java.lang.String informacaoAdicionalDoProduto);

    @net.vidageek.fluid.annotations.FluidField("nItem")
    Detalhe<T> withNumeroDoItemNaNF(java.lang.String numeroDoItemNaNF);

}