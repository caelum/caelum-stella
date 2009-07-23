package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Fat.class)
public interface Fatura<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nFat")
    Fatura<T> withNumeroDaFatura(java.lang.String numeroDaFatura);

    @net.vidageek.fluid.annotations.FluidField("vOrig")
    Fatura<T> withValorOriginal(java.math.BigDecimal valorOriginal);

    @net.vidageek.fluid.annotations.FluidField("vDesc")
    Fatura<T> withValorDeDesconto(java.math.BigDecimal valorDeDesconto);

    @net.vidageek.fluid.annotations.FluidField("vLiq")
    Fatura<T> withValorLiquido(java.math.BigDecimal valorLiquido);

}