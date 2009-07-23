package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.SignatureType.class)
public interface SignatureType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("signedInfo")
    SignedInfoType<SignatureType<T>> withSignedInfo();

    @net.vidageek.fluid.annotations.FluidField("signatureValue")
    SignatureValueType<SignatureType<T>> withSignatureValue();

    @net.vidageek.fluid.annotations.FluidField("keyInfo")
    KeyInfoType<SignatureType<T>> withKeyInfo();

    @net.vidageek.fluid.annotations.FluidField("id")
    SignatureType<T> withId(java.lang.String id);

}