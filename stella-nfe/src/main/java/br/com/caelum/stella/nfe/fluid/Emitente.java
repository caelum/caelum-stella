package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Emit.class)
public interface Emitente<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    Emitente<T> withCNPJ(br.com.caelum.stella.tinytype.CNPJ CNPJ);

    @net.vidageek.fluid.annotations.FluidField("cpf")
    Emitente<T> withCPF(br.com.caelum.stella.tinytype.CPF CPF);

    @net.vidageek.fluid.annotations.FluidField("xNome")
    Emitente<T> withRazaoSocial(java.lang.String razaoSocial);

    @net.vidageek.fluid.annotations.FluidField("xFant")
    Emitente<T> withNomeFantasia(java.lang.String nomeFantasia);

    @net.vidageek.fluid.annotations.FluidField("enderEmit")
    Endereco<Emitente<T>> withEnderecoDoEmitente();

    @net.vidageek.fluid.annotations.FluidField("ie")
    Emitente<T> withInscricaoEstadual(java.lang.String inscricaoEstadual);

    @net.vidageek.fluid.annotations.FluidField("iest")
    Emitente<T> withInscricaoEstadualDoSubstitutoTributario(java.lang.String inscricaoEstadualDoSubstitutoTributario);

    @net.vidageek.fluid.annotations.FluidField("im")
    Emitente<T> withInscricaoMunicipal(java.lang.String inscricaoMunicipal);

    @net.vidageek.fluid.annotations.FluidField("cnae")
    Emitente<T> withCNAEFiscal(java.lang.String CNAEFiscal);

}