package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TProcInutNFe.class)
public interface TProcInutNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("inutNFe")
    TInutNFe<TProcInutNFe<T>> withInutNFe();

    @net.vidageek.fluid.annotations.FluidField("retInutNFe")
    TRetInutNFe<TProcInutNFe<T>> withRetInutNFe();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TProcInutNFe<T> withVersao(java.lang.String versao);

}