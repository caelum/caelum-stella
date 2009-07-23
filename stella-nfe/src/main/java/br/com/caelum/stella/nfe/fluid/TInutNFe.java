package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TInutNFe.class)
public interface TInutNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infInut")
    InfInut<TInutNFe<T>> withInfInut();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TInutNFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TInutNFe<T> withVersao(java.lang.String versao);

}