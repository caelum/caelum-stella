package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Adi.class)
public interface Adicao<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nAdicao")
    Adicao<T> withNumeroDaAdicao(java.lang.Integer numeroDaAdicao);

    @net.vidageek.fluid.annotations.FluidField("nSeqAdic")
    Adicao<T> withNumeroSequencialDoItemDaAdicao(java.lang.Integer numeroSequencialDoItemDaAdicao);

    @net.vidageek.fluid.annotations.FluidField("cFabricante")
    Adicao<T> withCodigoDoFabricanteEstrangeiro(java.lang.String codigoDoFabricanteEstrangeiro);

    @net.vidageek.fluid.annotations.FluidField("vDescDI")
    Adicao<T> withValorDeDescontoDoItemDaDI(java.math.BigDecimal valorDeDescontoDoItemDaDI);

}