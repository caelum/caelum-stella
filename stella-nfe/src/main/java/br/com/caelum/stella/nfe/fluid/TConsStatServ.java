package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TConsStatServ.class)
public interface TConsStatServ<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    TConsStatServ<T> withTpAmb(java.lang.String tpAmb);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    TConsStatServ<T> withCuf(java.lang.String cuf);

    @net.vidageek.fluid.annotations.FluidField("xServ")
    TConsStatServ<T> withXServ(java.lang.String xServ);

    @net.vidageek.fluid.annotations.FluidField("versao")
    TConsStatServ<T> withVersao(java.lang.String versao);

}