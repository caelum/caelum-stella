package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PISQtde.class)
public interface PISTributadoPorQuantidade<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cst")
    PISTributadoPorQuantidade<T> withCst(java.lang.String cst);

    @net.vidageek.fluid.annotations.FluidField("qbcProd")
    PISTributadoPorQuantidade<T> withQuantidadeVendida(java.math.BigDecimal quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("vAliqProd")
    PISTributadoPorQuantidade<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    PISTributadoPorQuantidade<T> withValorDoPIS(java.math.BigDecimal valorDoPIS);

}