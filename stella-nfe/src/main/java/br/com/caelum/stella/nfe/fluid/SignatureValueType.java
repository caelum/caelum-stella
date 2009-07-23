package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.SignatureValueType.class)
public interface SignatureValueType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("value")
    SignatureValueType<T> withValue(byte[] value);

    @net.vidageek.fluid.annotations.FluidField("id")
    SignatureValueType<T> withId(java.lang.String id);

}