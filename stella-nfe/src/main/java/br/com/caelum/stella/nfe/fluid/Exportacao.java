package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Exporta.class)
public interface Exportacao<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("ufEmbarq")
    Exportacao<T> withUFDoEmbarque(br.com.caelum.stella.nfe.modelo.UF UFDoEmbarque);

    @net.vidageek.fluid.annotations.FluidField("xLocEmbarq")
    Exportacao<T> withLocalDoEmbarque(java.lang.String localDoEmbarque);

}