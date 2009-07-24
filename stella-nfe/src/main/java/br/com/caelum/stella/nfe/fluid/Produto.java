package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Prod.class)
public interface Produto<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cProd")
    Produto<T> withCodigoDoProduto(java.lang.String codigoDoProduto);

    @net.vidageek.fluid.annotations.FluidField("cean")
    Produto<T> withCodigoEAN(java.lang.String codigoEAN);

    @net.vidageek.fluid.annotations.FluidField("xProd")
    Produto<T> withDescricaoDoProduto(java.lang.String descricaoDoProduto);

    @net.vidageek.fluid.annotations.FluidField("ncm")
    Produto<T> withCodigoNCM(java.lang.String codigoNCM);

    @net.vidageek.fluid.annotations.FluidField("extipi")
    Produto<T> withCodigoEXTIPI(java.lang.String codigoEXTIPI);

    @net.vidageek.fluid.annotations.FluidField("genero")
    Produto<T> withGenero(java.lang.String genero);

    @net.vidageek.fluid.annotations.FluidField("cfop")
    Produto<T> withCodigoFiscalDeOperacoesEPrestacoes(java.lang.String codigoFiscalDeOperacoesEPrestacoes);

    @net.vidageek.fluid.annotations.FluidField("uCom")
    Produto<T> withUnidadeComercial(java.lang.String unidadeComercial);

    @net.vidageek.fluid.annotations.FluidField("qCom")
    Produto<T> withQuantidadeComercial(java.math.BigDecimal quantidadeComercial);

    @net.vidageek.fluid.annotations.FluidField("vUnCom")
    Produto<T> withValorUnitarioDeComercializacao(java.math.BigDecimal valorUnitarioDeComercializacao);

    @net.vidageek.fluid.annotations.FluidField("vProd")
    Produto<T> withValorBrutoDoProduto(java.math.BigDecimal valorBrutoDoProduto);

    @net.vidageek.fluid.annotations.FluidField("ceanTrib")
    Produto<T> withCodigoEANDaUnidadeTributavel(java.lang.String codigoEANDaUnidadeTributavel);

    @net.vidageek.fluid.annotations.FluidField("uTrib")
    Produto<T> withUnidadeTributavel(java.math.BigDecimal unidadeTributavel);

    @net.vidageek.fluid.annotations.FluidField("qTrib")
    Produto<T> withQuantidadeTributavel(java.math.BigDecimal quantidadeTributavel);

    @net.vidageek.fluid.annotations.FluidField("vUnTrib")
    Produto<T> withValorUnitarioDeTributacao(java.math.BigDecimal valorUnitarioDeTributacao);

    @net.vidageek.fluid.annotations.FluidField("vFrete")
    Produto<T> withValorDoFrete(java.math.BigDecimal valorDoFrete);

    @net.vidageek.fluid.annotations.FluidField("vSeg")
    Produto<T> withValorDoSeguro(java.math.BigDecimal valorDoSeguro);

    @net.vidageek.fluid.annotations.FluidField("vDesc")
    Produto<T> withValorDeDesconto(java.math.BigDecimal ValorDeDesconto);

    @net.vidageek.fluid.annotations.FluidField("di")
    DeclaracaoDeImportacao<Produto<T>> addDI();

    @net.vidageek.fluid.annotations.FluidField("veicProd")
    VeiculoNovo<Produto<T>> withVeiculoNovo();

    @net.vidageek.fluid.annotations.FluidField("med")
    Medicamento<Produto<T>> addMedicamento();

    @net.vidageek.fluid.annotations.FluidField("arma")
    Armamento<Produto<T>> addArmamento();

    @net.vidageek.fluid.annotations.FluidField("comb")
    Combustivel<Produto<T>> withCombustivel();

}