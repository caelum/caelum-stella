package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINSST.class)
public interface COFINSSubstituicaoTributaria<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    COFINSSubstituicaoTributaria<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquotaEmPercentual")
    COFINSSubstituicaoTributaria<T> withAliquotaEmPercentual(java.math.BigDecimal aliquotaEmPercentual);

    @net.vidageek.fluid.annotations.FluidField("quantidadeVendida")
    COFINSSubstituicaoTributaria<T> withQuantidadeVendida(java.math.BigDecimal quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    COFINSSubstituicaoTributaria<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    COFINSSubstituicaoTributaria<T> withValor(java.math.BigDecimal valor);

}