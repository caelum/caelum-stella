package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfCons.class)
public interface InfCons<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    InfCons<T> withVerAplic(java.lang.String verAplic);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    InfCons<T> withCStat(java.lang.String cStat);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    InfCons<T> withXMotivo(java.lang.String xMotivo);

    @net.vidageek.fluid.annotations.FluidField("uf")
    InfCons<T> withUf(br.com.caelum.stella.nfe.modelo.TUfCons uf);

    @net.vidageek.fluid.annotations.FluidField("ie")
    InfCons<T> withIe(java.lang.String ie);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    InfCons<T> withCnpj(java.lang.String cnpj);

    @net.vidageek.fluid.annotations.FluidField("cpf")
    InfCons<T> withCpf(java.lang.String cpf);

    @net.vidageek.fluid.annotations.FluidField("dhCons")
    InfCons<T> withDhCons(java.lang.String dhCons);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    InfCons<T> withCuf(java.lang.String cuf);

    @net.vidageek.fluid.annotations.FluidField("infCad")
    InfCons<T> addInfCad();

}