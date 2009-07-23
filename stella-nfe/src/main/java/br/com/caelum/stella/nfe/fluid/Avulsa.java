package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Avulsa.class)
public interface Avulsa<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    Avulsa<T> withCNPJ(br.com.caelum.stella.tinytype.CNPJ CNPJ);

    @net.vidageek.fluid.annotations.FluidField("xOrgao")
    Avulsa<T> withOrgaoEmitente(java.lang.String orgaoEmitente);

    @net.vidageek.fluid.annotations.FluidField("matr")
    Avulsa<T> withMatriculaDoAgente(java.lang.String matriculaDoAgente);

    @net.vidageek.fluid.annotations.FluidField("xAgente")
    Avulsa<T> withNomeDoAgente(java.lang.String nomeDoAgente);

    @net.vidageek.fluid.annotations.FluidField("fone")
    Avulsa<T> withTelefone(java.lang.Long telefone);

    @net.vidageek.fluid.annotations.FluidField("uf")
    Avulsa<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

    @net.vidageek.fluid.annotations.FluidField("ndar")
    Avulsa<T> withNumeroDeArrecadacaoDaReceita(java.lang.String numeroDeArrecadacaoDaReceita);

    @net.vidageek.fluid.annotations.FluidField("dEmi")
    Avulsa<T> withDataDeEmissao(java.util.Calendar dataDeEmissao);

    @net.vidageek.fluid.annotations.FluidField("vdar")
    Avulsa<T> withValorDoDocumentoDeArrecadacao(java.math.BigDecimal valorDoDocumentoDeArrecadacao);

    @net.vidageek.fluid.annotations.FluidField("repEmi")
    Avulsa<T> withReparticaoFiscalEmitente(java.lang.String reparticaoFiscalEmitente);

    @net.vidageek.fluid.annotations.FluidField("dPag")
    Avulsa<T> withDataDePagamento(java.util.Calendar dataDePagamento);

}