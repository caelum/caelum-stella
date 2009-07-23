package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS00.class)
public interface ICMS00<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS00<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS00<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeBaseCalculo")
    ICMS00<T> withModalidadeBaseCalculo(java.lang.String modalidadeBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ICMS00<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ICMS00<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    ICMS00<T> withValor(java.lang.String valor);

}