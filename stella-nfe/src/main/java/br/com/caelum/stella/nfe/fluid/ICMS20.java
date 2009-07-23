package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS20.class)
public interface ICMS20<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("origem")
    ICMS20<T> withOrigem(java.lang.String origem);

    @net.vidageek.fluid.annotations.FluidField("tipoTributacao")
    ICMS20<T> withTipoTributacao(java.lang.String tipoTributacao);

    @net.vidageek.fluid.annotations.FluidField("modalidadeBaseCalculo")
    ICMS20<T> withModalidadeBaseCalculo(java.lang.String modalidadeBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("percentualReducaoBaseCalculo")
    ICMS20<T> withPercentualReducaoBaseCalculo(java.lang.String percentualReducaoBaseCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ICMS20<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ICMS20<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valor")
    ICMS20<T> withValor(java.lang.String valor);

}