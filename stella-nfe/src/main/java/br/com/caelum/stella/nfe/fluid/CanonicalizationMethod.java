package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.CanonicalizationMethod.class)
public interface CanonicalizationMethod<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("algorithm")
    CanonicalizationMethod<T> withAlgorithm(java.lang.String algorithm);

}