package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS60.class)
public interface ICMS60<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS60<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS60<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculoSubstituicaoTributaria")
    ICMS60<T> withValorDaBaseDeCalculoSubstituicaoTributaria(java.lang.String valorDaBaseDeCalculoSubstituicaoTributaria);

    @net.vidageek.fluid.annotations.FluidField("valorSubstituicaoTributaria")
    ICMS60<T> withValorSubstituicaoTributaria(java.lang.String valorSubstituicaoTributaria);

}