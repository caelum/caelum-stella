package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PISAliq.class)
public interface PISTributadoPelaAliquota<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cst")
    PISTributadoPelaAliquota<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("vbc")
    PISTributadoPelaAliquota<T> withValorDaBaseDeCalculo(java.math.BigDecimal valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("ppis")
    PISTributadoPelaAliquota<T> withAliquotaDoPIS(java.math.BigDecimal aliquotaDoPIS);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    PISTributadoPelaAliquota<T> withValorDoPIS(java.math.BigDecimal valorDoPIS);

}