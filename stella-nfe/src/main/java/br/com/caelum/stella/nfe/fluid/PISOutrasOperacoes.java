package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PISOutr.class)
public interface PISOutrasOperacoes<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cst")
    PISOutrasOperacoes<T> withCst(java.lang.String cst);

    @net.vidageek.fluid.annotations.FluidField("vbc")
    PISOutrasOperacoes<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("ppis")
    PISOutrasOperacoes<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("qbcProd")
    PISOutrasOperacoes<T> withQuantidadeVendida(java.math.BigDecimal quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("vAliqProd")
    PISOutrasOperacoes<T> withAliquotaDoProduto(java.math.BigDecimal aliquotaDoProduto);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    PISOutrasOperacoes<T> withValor(java.math.BigDecimal valor);

}