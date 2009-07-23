package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Total.class)
public interface TotalNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("icmsTot")
    ICMSTotal<TotalNFE<T>> withICMSTotal();

    @net.vidageek.fluid.annotations.FluidField("issqNtot")
    ISSQNtot<TotalNFE<T>> withISSQNTotal();

    @net.vidageek.fluid.annotations.FluidField("retTrib")
    RetencaoDeTributosFederais<TotalNFE<T>> withRetencaoDeTributosFederais();

}