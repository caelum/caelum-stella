package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetInutNFe.class)
public interface TRetInutNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infInut")
    InfInut<TRetInutNFe<T>> withInfInut();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TRetInutNFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetInutNFe<T> withVersao(java.lang.String versao);

}