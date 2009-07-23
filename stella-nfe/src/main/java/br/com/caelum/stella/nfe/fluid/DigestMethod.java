package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.DigestMethod.class)
public interface DigestMethod<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("algorithm")
    DigestMethod<T> withAlgorithm(java.lang.String algorithm);

}