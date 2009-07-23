package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS70.class)
public interface ICMS70<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS70<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS70<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeBaseCalculo")
    ICMS70<T> withModalidadeBaseCalculo(java.lang.String modalidadeBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoBaseCalculo")
    ICMS70<T> withPercentualReducaoBaseCalculo(java.lang.String percentualReducaoBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ICMS70<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ICMS70<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    ICMS70<T> withValor(java.lang.String valor);

    @net.vidageek.fluid.annotations.FluidField("modalidadeSubstituicaoTributaria")
    ICMS70<T> withModalidadeSubstituicaoTributaria(java.lang.String modalidadeSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualAdicionadoSubstituicaoTributaria")
    ICMS70<T> withPercentualAdicionadoSubstituicaoTributaria(java.lang.String percentualAdicionadoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoSubstituicaoTributaria")
    ICMS70<T> withPercentualReducaoSubstituicaoTributaria(java.lang.String percentualReducaoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculoSubstituicaoTributaria")
    ICMS70<T> withValorDaBaseDeCalculoSubstituicaoTributaria(java.lang.String valorDaBaseDeCalculoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("aliquotaSubstituicaoTributaria")
    ICMS70<T> withAliquotaSubstituicaoTributaria(java.lang.String aliquotaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorSubstituicaoTributaria")
    ICMS70<T> withValorSubstituicaoTributaria(java.lang.String valorSubstituicaoTributaria);

}