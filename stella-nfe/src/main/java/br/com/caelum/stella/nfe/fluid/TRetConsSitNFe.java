package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetConsSitNFe.class)
public interface TRetConsSitNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infProt")
    Protocolo<TRetConsSitNFe<T>> withInfProt();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TRetConsSitNFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetConsSitNFe<T> withVersao(java.lang.String versao);

}