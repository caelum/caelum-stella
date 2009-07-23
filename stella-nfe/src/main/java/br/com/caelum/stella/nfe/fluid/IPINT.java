package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.IPINT.class)
public interface IPINT<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("codigoSituacaoTributaria")
    IPINT<T> withCodigoSituacaoTributaria(java.lang.String codigoSituacaoTributaria);

}