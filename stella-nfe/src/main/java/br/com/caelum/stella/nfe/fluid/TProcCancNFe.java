package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TProcCancNFe.class)
public interface TProcCancNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cancNFe")
    TCancNFe<TProcCancNFe<T>> withCancNFe();

    @net.vidageek.fluid.annotations.FluidField("retCancNFe")
    TRetCancNFe<TProcCancNFe<T>> withRetCancNFe();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TProcCancNFe<T> withVersao(java.lang.String versao);

}