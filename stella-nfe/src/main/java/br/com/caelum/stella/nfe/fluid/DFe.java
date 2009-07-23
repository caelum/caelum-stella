package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.DFe.class)
public interface DFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("mod")
    DFe<T> withMod(java.lang.String mod);

    @net.vidageek.fluid.annotations.FluidField("sit")
    DFe<T> withSit(java.lang.String sit);

}