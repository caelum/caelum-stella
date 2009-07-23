package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS10.class)
public interface ICMS10<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS10<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS10<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeBaseCalculo")
    ICMS10<T> withModalidadeBaseCalculo(java.lang.String modalidadeBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ICMS10<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ICMS10<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    ICMS10<T> withValor(java.lang.String valor);

    @net.vidageek.fluid.annotations.FluidField("modalidadeSubstituicaoTributaria")
    ICMS10<T> withModalidadeSubstituicaoTributaria(java.lang.String modalidadeSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualAdicionadoSubstituicaoTributaria")
    ICMS10<T> withPercentualAdicionadoSubstituicaoTributaria(java.lang.String percentualAdicionadoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoBaseCalculo")
    ICMS10<T> withPercentualReducaoBaseCalculo(java.lang.String percentualReducaoBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculoSubstituicaoTributaria")
    ICMS10<T> withValorDaBaseDeCalculoSubstituicaoTributaria(java.lang.String valorDaBaseDeCalculoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("aliquotaSubstituicaoTributaria")
    ICMS10<T> withAliquotaSubstituicaoTributaria(java.lang.String aliquotaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorSubstituicaoTributaria")
    ICMS10<T> withValorSubstituicaoTributaria(java.lang.String valorSubstituicaoTributaria);

}