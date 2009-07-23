package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Dest.class)
public interface Destinatario<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    Destinatario<T> withCNPJ(br.com.caelum.stella.tinytype.CNPJ CNPJ);

    @net.vidageek.fluid.annotations.FluidField("cpf")
    Destinatario<T> withCPF(br.com.caelum.stella.tinytype.CPF CPF);

    @net.vidageek.fluid.annotations.FluidField("xNome")
    Destinatario<T> withRazaoSocial(java.lang.String razaoSocial);

    @net.vidageek.fluid.annotations.FluidField("enderDest")
    Endereco<Destinatario<T>> withEndererecoDoDestinatario();

    @net.vidageek.fluid.annotations.FluidField("ie")
    Destinatario<T> withInscricaoEstadual(java.lang.String inscricaoEstadual);

    @net.vidageek.fluid.annotations.FluidField("isuf")
    Destinatario<T> withInscricaoNaSUFRAMA(java.lang.String inscricaoNaSUFRAMA);

}