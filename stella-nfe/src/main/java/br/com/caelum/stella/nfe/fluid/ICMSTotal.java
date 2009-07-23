package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMSTot.class)
public interface ICMSTotal<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vbc")
    ICMSTotal<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("vicms")
    ICMSTotal<T> withValorTotal(java.math.BigDecimal valorTotal);

    @net.vidageek.fluid.annotations.FluidField("vbcst")
    ICMSTotal<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributaria(java.math.BigDecimal valorDaBaseDeCalculoDoICMSSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("vst")
    ICMSTotal<T> withValorTotalDoICMSSubstituicaoTributaria(java.math.BigDecimal valorTotalDoICMSSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("vProd")
    ICMSTotal<T> withValorTotalDosProdutosEServicos(java.math.BigDecimal valorTotalDosProdutosEServicos);

    @net.vidageek.fluid.annotations.FluidField("vFrete")
    ICMSTotal<T> withValorTotalDoFrete(java.math.BigDecimal valorTotalDoFrete);

    @net.vidageek.fluid.annotations.FluidField("vSeg")
    ICMSTotal<T> withValorTotalDoSeguro(java.math.BigDecimal valorTotalDoSeguro);

    @net.vidageek.fluid.annotations.FluidField("vDesc")
    ICMSTotal<T> withValorTotalDeDesconto(java.math.BigDecimal valorTotalDeDesconto);

    @net.vidageek.fluid.annotations.FluidField("vii")
    ICMSTotal<T> withValorTotalDoII(java.math.BigDecimal valorTotalDoII);

    @net.vidageek.fluid.annotations.FluidField("vipi")
    ICMSTotal<T> withValorTotalDoIPI(java.math.BigDecimal valorTotalDoIPI);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    ICMSTotal<T> withValorTotalDoPIS(java.math.BigDecimal valorTotalDoPIS);

    @net.vidageek.fluid.annotations.FluidField("vcofins")
    ICMSTotal<T> withValor(java.math.BigDecimal valor);

    @net.vidageek.fluid.annotations.FluidField("vOutro")
    ICMSTotal<T> withValorTotalDeOutrasDespesas(java.math.BigDecimal valorTotalDeOutrasDespesas);

    @net.vidageek.fluid.annotations.FluidField("vnf")
    ICMSTotal<T> withValorTotalDaNF(java.math.BigDecimal valorTotalDaNF);

}