package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TLocal.class)
public interface DadosDoLocal<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    DadosDoLocal<T> withCNPJ(br.com.caelum.stella.tinytype.CNPJ CNPJ);

    @net.vidageek.fluid.annotations.FluidField("xLgr")
    DadosDoLocal<T> withLogradouro(java.lang.String logradouro);

    @net.vidageek.fluid.annotations.FluidField("nro")
    DadosDoLocal<T> withNumero(java.lang.String numero);

    @net.vidageek.fluid.annotations.FluidField("xCpl")
    DadosDoLocal<T> withComplemento(java.lang.String complemento);

    @net.vidageek.fluid.annotations.FluidField("xBairro")
    DadosDoLocal<T> withBairro(java.lang.String bairro);

    @net.vidageek.fluid.annotations.FluidField("cMun")
    DadosDoLocal<T> withCodigoDoMunicipio(java.lang.String codigoDoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("xMun")
    DadosDoLocal<T> withNomeDoMunicipio(java.lang.String nomeDoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("uf")
    DadosDoLocal<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

}