package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS90.class)
public interface ICMS90<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS90<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS90<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeBaseCalculo")
    ICMS90<T> withModalidadeBaseCalculo(java.lang.String modalidadeBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ICMS90<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoBaseCalculo")
    ICMS90<T> withPercentualReducaoBaseCalculo(java.lang.String percentualReducaoBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ICMS90<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    ICMS90<T> withValor(java.lang.String valor);

    @net.vidageek.fluid.annotations.FluidField("modalidadeSubstituicaoTributaria")
    ICMS90<T> withModalidadeSubstituicaoTributaria(java.lang.String modalidadeSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualAdicionadoSubstituicaoTributaria")
    ICMS90<T> withPercentualAdicionadoSubstituicaoTributaria(java.lang.String percentualAdicionadoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoSubstituicaoTributaria")
    ICMS90<T> withPercentualReducaoSubstituicaoTributaria(java.lang.String percentualReducaoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculoSubstituicaoTributaria")
    ICMS90<T> withValorDaBaseDeCalculoSubstituicaoTributaria(java.lang.String valorDaBaseDeCalculoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("aliquotaSubstituicaoTributaria")
    ICMS90<T> withAliquotaSubstituicaoTributaria(java.lang.String aliquotaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorSubstituicaoTributaria")
    ICMS90<T> withValorSubstituicaoTributaria(java.lang.String valorSubstituicaoTributaria);

}