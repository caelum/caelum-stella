package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.IPITrib.class)
public interface IPITrib<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    IPITrib<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    IPITrib<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquotaIPI")
    IPITrib<T> withAliquotaIPI(java.lang.String aliquotaIPI);

    @net.vidageek.fluid.annotations.FluidField("quantidade")
    IPITrib<T> withQuantidade(java.lang.String quantidade);

    @net.vidageek.fluid.annotations.FluidField("valorUnidade")
    IPITrib<T> withValorUnidade(java.lang.String valorUnidade);

    @net.vidageek.fluid.annotations.FluidField("valorIPI")
    IPITrib<T> withValorIPI(java.lang.String valorIPI);

}