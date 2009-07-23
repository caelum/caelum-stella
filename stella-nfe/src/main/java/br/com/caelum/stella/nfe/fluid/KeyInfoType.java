package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.KeyInfoType.class)
public interface KeyInfoType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("x509Data")
    X509DataType<KeyInfoType<T>> withX509Data();

    @net.vidageek.fluid.annotations.FluidField("id")
    KeyInfoType<T> withId(java.lang.String id);

}