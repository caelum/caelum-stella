package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.SignatureMethod.class)
public interface SignatureMethod<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("algorithm")
    SignatureMethod<T> withAlgorithm(java.lang.String algorithm);

}