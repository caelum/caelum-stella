package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINS.class)
public interface COFINS<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cofinsAliq")
    COFINSTributadoPelaAliquota<COFINS<T>> withTributacaoPelaAliquota();

    @net.vidageek.fluid.annotations.FluidField("cofinsQtde")
    COFINSTributadoPelaQuantidade<COFINS<T>> withTributacaoPelaQuantidade();

    @net.vidageek.fluid.annotations.FluidField("cofinsnt")
    COFINSNaoTributado<COFINS<T>> withNaoTributado();

    @net.vidageek.fluid.annotations.FluidField("cofinsOutr")
    COFINSOutrasOperacoes<COFINS<T>> withTributacaoDeOutrasOperacoes();

}