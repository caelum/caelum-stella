package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINSQtde.class)
public interface COFINSTributadoPelaQuantidade<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    COFINSTributadoPelaQuantidade<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("quantidadeVendida")
    COFINSTributadoPelaQuantidade<T> withQuantidadeVendida(java.math.BigDecimal quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    COFINSTributadoPelaQuantidade<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    COFINSTributadoPelaQuantidade<T> withValor(java.math.BigDecimal valor);

}