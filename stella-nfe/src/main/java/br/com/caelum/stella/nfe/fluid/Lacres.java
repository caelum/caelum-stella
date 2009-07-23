package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Lacres.class)
public interface Lacres<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nLacre")
    Lacres<T> withNumeroDosLacres(java.lang.String numeroDosLacres);

}