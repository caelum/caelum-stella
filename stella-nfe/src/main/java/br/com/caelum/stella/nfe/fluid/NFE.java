package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TNFe.class)
public interface NFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infNFe")
    InformacoesDaNFE<NFE<T>> withInformacoesDaNFE();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<NFE<T>> withSignature();

}