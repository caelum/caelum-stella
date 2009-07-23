package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TProtNFe.class)
public interface ProtocoloDoResultadoDeProcessamento<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infProt")
    Protocolo<ProtocoloDoResultadoDeProcessamento<T>> withDadosDoProtocolo();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<ProtocoloDoResultadoDeProcessamento<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    ProtocoloDoResultadoDeProcessamento<T> withVersao(java.lang.String versao);

}