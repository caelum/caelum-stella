package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetConsStatServ.class)
public interface TRetConsStatServ<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    TRetConsStatServ<T> withTpAmb(java.lang.String tpAmb);

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    TRetConsStatServ<T> withVerAplic(java.lang.String verAplic);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    TRetConsStatServ<T> withCStat(java.lang.String cStat);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    TRetConsStatServ<T> withXMotivo(java.lang.String xMotivo);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    TRetConsStatServ<T> withCuf(java.lang.String cuf);

    @net.vidageek.fluid.annotations.FluidField("dhRecbto")
    TRetConsStatServ<T> withDhRecbto(java.lang.String dhRecbto);

    @net.vidageek.fluid.annotations.FluidField("tMed")
    TRetConsStatServ<T> withTMed(java.lang.String tMed);

    @net.vidageek.fluid.annotations.FluidField("dhRetorno")
    TRetConsStatServ<T> withDhRetorno(java.lang.String dhRetorno);

    @net.vidageek.fluid.annotations.FluidField("xObs")
    TRetConsStatServ<T> withXObs(java.lang.String xObs);

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetConsStatServ<T> withVersao(java.lang.String versao);

}