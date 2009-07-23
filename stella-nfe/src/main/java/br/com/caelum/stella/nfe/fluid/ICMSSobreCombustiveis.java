package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMSComb.class)
public interface ICMSSobreCombustiveis<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vbcicms")
    ICMSSobreCombustiveis<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("vicms")
    ICMSSobreCombustiveis<T> withValor(java.math.BigDecimal valor);

    @net.vidageek.fluid.annotations.FluidField("vbcicmsst")
    ICMSSobreCombustiveis<T> withValorDaBaseDeCalculoDaSubstituicaoTributaria(java.math.BigDecimal valorDaBaseDeCalculoDaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("vicmsst")
    ICMSSobreCombustiveis<T> withValorDoICMSDaSubstituicaoTributaria(java.math.BigDecimal valorDoICMSDaSubstituicaoTributaria);

}