package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TEndereco.class)
public interface Endereco<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("xLgr")
    Endereco<T> withLogradouro(java.lang.String Logradouro);

    @net.vidageek.fluid.annotations.FluidField("nro")
    Endereco<T> withNumero(java.lang.String numero);

    @net.vidageek.fluid.annotations.FluidField("xCpl")
    Endereco<T> withComplemento(java.lang.String complemento);

    @net.vidageek.fluid.annotations.FluidField("xBairro")
    Endereco<T> withBairro(java.lang.String bairro);

    @net.vidageek.fluid.annotations.FluidField("cMun")
    Endereco<T> withCodigoDoMunicipio(java.lang.String codigoDoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("xMun")
    Endereco<T> withNomeDoMunicipio(java.lang.String nomeDoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("uf")
    Endereco<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

    @net.vidageek.fluid.annotations.FluidField("cep")
    Endereco<T> withCEP(java.lang.String CEP);

    @net.vidageek.fluid.annotations.FluidField("cPais")
    Endereco<T> withCodigoDoPais(java.lang.String codigoDoPais);

    @net.vidageek.fluid.annotations.FluidField("xPais")
    Endereco<T> withNomeDoPais(java.lang.String nomeDoPais);

    @net.vidageek.fluid.annotations.FluidField("fone")
    Endereco<T> withTelefone(java.lang.String telefone);

}