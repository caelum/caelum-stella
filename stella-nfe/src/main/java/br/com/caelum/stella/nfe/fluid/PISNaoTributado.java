package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PISNT.class)
public interface PISNaoTributado<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cst")
    PISNaoTributado<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

}