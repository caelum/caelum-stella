package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINSAliq.class)
public interface COFINSTributadoPelaAliquota<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    COFINSTributadoPelaAliquota<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    COFINSTributadoPelaAliquota<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquotaEmPercentual")
    COFINSTributadoPelaAliquota<T> withAliquotaEmPercentual(java.math.BigDecimal aliquotaEmPercentual);

    @net.vidageek.fluid.annotations.FluidField("valor")
    COFINSTributadoPelaAliquota<T> withValor(java.lang.String valor);

}