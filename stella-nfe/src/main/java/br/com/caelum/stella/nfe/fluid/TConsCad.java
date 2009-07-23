package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TConsCad.class)
public interface TConsCad<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infCons")
    InfCons<TConsCad<T>> withInfCons();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TConsCad<T> withVersao(java.lang.String versao);

}