package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfCanc.class)
public interface InfCanc<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    InfCanc<T> withTpAmb(java.lang.String tpAmb);

    @net.vidageek.fluid.annotations.FluidField("xServ")
    InfCanc<T> withXServ(java.lang.String xServ);

    @net.vidageek.fluid.annotations.FluidField("chNFe")
    InfCanc<T> withChNFe(java.lang.String chNFe);

    @net.vidageek.fluid.annotations.FluidField("nProt")
    InfCanc<T> withNProt(java.lang.String nProt);

    @net.vidageek.fluid.annotations.FluidField("xJust")
    InfCanc<T> withXJust(java.lang.String xJust);

    @net.vidageek.fluid.annotations.FluidField("id")
    InfCanc<T> withId(java.lang.String id);

}