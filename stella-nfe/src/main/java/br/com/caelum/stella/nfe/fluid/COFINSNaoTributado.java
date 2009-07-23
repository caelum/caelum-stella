package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.COFINSNT.class)
public interface COFINSNaoTributado<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    COFINSNaoTributado<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

}