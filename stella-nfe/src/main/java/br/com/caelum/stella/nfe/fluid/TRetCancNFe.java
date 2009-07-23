package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetCancNFe.class)
public interface TRetCancNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infCanc")
    InfCanc<TRetCancNFe<T>> withInfCanc();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TRetCancNFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetCancNFe<T> withVersao(java.lang.String versao);

}