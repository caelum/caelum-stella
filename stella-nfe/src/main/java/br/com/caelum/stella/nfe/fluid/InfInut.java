package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfInut.class)
public interface InfInut<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    InfInut<T> withTpAmb(java.lang.String tpAmb);

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    InfInut<T> withVerAplic(java.lang.String verAplic);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    InfInut<T> withCStat(java.lang.String cStat);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    InfInut<T> withXMotivo(java.lang.String xMotivo);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    InfInut<T> withCuf(java.lang.String cuf);

    @net.vidageek.fluid.annotations.FluidField("ano")
    InfInut<T> withAno(java.lang.String ano);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    InfInut<T> withCnpj(java.lang.String cnpj);

    @net.vidageek.fluid.annotations.FluidField("mod")
    InfInut<T> withMod(java.lang.String mod);

    @net.vidageek.fluid.annotations.FluidField("serie")
    InfInut<T> withSerie(java.lang.String serie);

    @net.vidageek.fluid.annotations.FluidField("nnfIni")
    InfInut<T> withNnfIni(java.lang.String nnfIni);

    @net.vidageek.fluid.annotations.FluidField("nnfFin")
    InfInut<T> withNnfFin(java.lang.String nnfFin);

    @net.vidageek.fluid.annotations.FluidField("dhRecbto")
    InfInut<T> withDhRecbto(java.lang.String dhRecbto);

    @net.vidageek.fluid.annotations.FluidField("nProt")
    InfInut<T> withNProt(java.lang.String nProt);

    @net.vidageek.fluid.annotations.FluidField("id")
    InfInut<T> withId(java.lang.String id);

}