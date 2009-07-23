package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS30.class)
public interface ICMS30<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS30<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS30<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeSubstituicaoTributaria")
    ICMS30<T> withModalidadeSubstituicaoTributaria(java.lang.String modalidadeSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualAdicionadoSubstituicaoTributaria")
    ICMS30<T> withPercentualAdicionadoSubstituicaoTributaria(java.lang.String percentualAdicionadoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoSubstituicaoTributaria")
    ICMS30<T> withPercentualReducaoSubstituicaoTributaria(java.lang.String percentualReducaoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculoSubstituicaoTributaria")
    ICMS30<T> withValorDaBaseDeCalculoSubstituicaoTributaria(java.lang.String valorDaBaseDeCalculoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("aliquotaSubstituicaoTributaria")
    ICMS30<T> withAliquotaSubstituicaoTributaria(java.lang.String aliquotaSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorSubstituicaoTributaria")
    ICMS30<T> withValorSubstituicaoTributaria(java.lang.String valorSubstituicaoTributaria);

}