package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetConsCad.class)
public interface TRetConsCad<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infCons")
    InfCons<TRetConsCad<T>> withInfCons();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetConsCad<T> withVersao(java.lang.String versao);

}