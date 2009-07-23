package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.NFref.class)
public interface InformacaoDaNFReferenciada<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("refNFe")
    InformacaoDaNFReferenciada<T> withRefNFe(java.lang.String refNFe);

    @net.vidageek.fluid.annotations.FluidField("refNF")
    NFReferenciada<InformacaoDaNFReferenciada<T>> withRefNF();

}