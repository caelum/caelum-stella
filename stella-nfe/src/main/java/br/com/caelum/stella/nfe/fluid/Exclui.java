package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Exclui.class)
public interface Exclui<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("uf")
    Exclui<T> withUF(br.com.caelum.stella.nfe.modelo.TUf UF);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    Exclui<T> withCNPJ(br.com.caelum.stella.tinytype.CNPJ CNPJ);

}