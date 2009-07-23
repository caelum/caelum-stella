package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.CIDE.class)
public interface CIDESobreCombustiveis<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("qbcProd")
    CIDESobreCombustiveis<T> withBaseDeCalculo(java.math.BigDecimal baseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("vAliqProd")
    CIDESobreCombustiveis<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("vcide")
    CIDESobreCombustiveis<T> withValor(java.math.BigDecimal valor);

}