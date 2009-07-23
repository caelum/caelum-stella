package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PISST.class)
public interface PISSubstituicaoTributaria<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vbc")
    PISSubstituicaoTributaria<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("ppis")
    PISSubstituicaoTributaria<T> withAliquotaDaSubstituicaoTributaria(java.math.BigDecimal aliquotaDaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("qbcProd")
    PISSubstituicaoTributaria<T> withQuantidadeVendida(java.math.BigDecimal quantidadeVendida);

    @net.vidageek.fluid.annotations.FluidField("vAliqProd")
    PISSubstituicaoTributaria<T> withAliquota(java.math.BigDecimal aliquota);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    PISSubstituicaoTributaria<T> withValor(java.math.BigDecimal valor);

}