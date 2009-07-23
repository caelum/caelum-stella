package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TNfeProc.class)
public interface NFEProcessada<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nFe")
    NFE<NFEProcessada<T>> withNFE();

    @net.vidageek.fluid.annotations.FluidField("protNFe")
    ProtocoloDoResultadoDeProcessamento<NFEProcessada<T>> withProtocoloDoResultadoDeProcessamento();

    @net.vidageek.fluid.annotations.FluidField("versao")
    NFEProcessada<T> withVersao(java.lang.String versao);

}