package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS40.class)
public interface ICMS40<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS40<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS40<T> withTipoTributacao(java.lang.String tipoTributacao);

}