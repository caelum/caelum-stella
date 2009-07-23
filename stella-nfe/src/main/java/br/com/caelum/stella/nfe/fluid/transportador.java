package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Transporta.class)
public interface transportador<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    transportador<T> withCNPJ(java.lang.String CNPJ);

    @net.vidageek.fluid.annotations.FluidField("cpf")
    transportador<T> withCPF(java.lang.String CPF);

    @net.vidageek.fluid.annotations.FluidField("xNome")
    transportador<T> withNome(java.lang.String nome);

    @net.vidageek.fluid.annotations.FluidField("ie")
    transportador<T> withInscricaoEstadual(java.lang.String inscricaoEstadual);

    @net.vidageek.fluid.annotations.FluidField("xEnder")
    transportador<T> withEnderecoCompleto(java.lang.String enderecoCompleto);

    @net.vidageek.fluid.annotations.FluidField("xMun")
    transportador<T> withNomeDoMunicipio(java.lang.String nomeDoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("uf")
    transportador<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

}