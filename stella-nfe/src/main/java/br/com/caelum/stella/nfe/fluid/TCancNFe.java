package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TCancNFe.class)
public interface TCancNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infCanc")
    InfCanc<TCancNFe<T>> withInfCanc();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TCancNFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TCancNFe<T> withVersao(java.lang.String versao);

}