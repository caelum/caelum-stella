package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINSOutr.class)
public interface COFINSOutrasOperacoes<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    COFINSOutrasOperacoes<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    COFINSOutrasOperacoes<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquotaEmPercentual")
    COFINSOutrasOperacoes<T> withAliquotaEmPercentual(java.math.BigDecimal aliquotaEmPercentual);

    @net.vidageek.fluid.annotations.FluidField("quantidadeVendida")
    COFINSOutrasOperacoes<T> withQuantidadeVendida(java.lang.String quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    COFINSOutrasOperacoes<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    COFINSOutrasOperacoes<T> withValor(java.lang.String valor);

}