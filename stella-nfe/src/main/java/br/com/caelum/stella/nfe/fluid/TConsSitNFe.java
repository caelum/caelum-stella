package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TConsSitNFe.class)
public interface TConsSitNFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    TConsSitNFe<T> withTpAmb(java.lang.String tpAmb);

    @net.vidageek.fluid.annotations.FluidField("xServ")
    TConsSitNFe<T> withXServ(java.lang.String xServ);

    @net.vidageek.fluid.annotations.FluidField("chNFe")
    TConsSitNFe<T> withChNFe(java.lang.String chNFe);

    @net.vidageek.fluid.annotations.FluidField("versao")
    TConsSitNFe<T> withVersao(java.lang.String versao);

}