package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Comb.class)
public interface Combustivel<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cProdANP")
    Combustivel<T> withCodigoDoProdutoNaANP(java.lang.String codigoDoProdutoNaANP);

    @net.vidageek.fluid.annotations.FluidField("codif")
    Combustivel<T> withCodigoDeAutorizacaoOuRegistroDoCODIF(java.math.BigInteger codigoDeAutorizacaoOuRegistroDoCODIF);

    @net.vidageek.fluid.annotations.FluidField("qTemp")
    Combustivel<T> withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(java.math.BigDecimal quantidadeDeCombustivelFaturadaNaTemperaturaAmbiente);

    @net.vidageek.fluid.annotations.FluidField("cide")
    CIDESobreCombustiveis<Combustivel<T>> withCIDE();

    @net.vidageek.fluid.annotations.FluidField("icmsComb")
    ICMSSobreCombustiveis<Combustivel<T>> withICMS();

    @net.vidageek.fluid.annotations.FluidField("icmsInter")
    ICMSSobreOperacoesInterestaduais<Combustivel<T>> withICMSSobreOperacoesInterestaduais();

    @net.vidageek.fluid.annotations.FluidField("icmsCons")
    ICMSSobreConsumo<Combustivel<T>> withICMSSobreConsumo();

}