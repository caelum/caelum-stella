package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.X509DataType.class)
public interface X509DataType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("x509Certificate")
    X509DataType<T> withX509Certificate(byte[] x509Certificate);

}