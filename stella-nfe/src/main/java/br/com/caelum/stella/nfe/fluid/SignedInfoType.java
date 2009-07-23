package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.SignedInfoType.class)
public interface SignedInfoType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("canonicalizationMethod")
    CanonicalizationMethod<SignedInfoType<T>> withCanonicalizationMethod();

    @net.vidageek.fluid.annotations.FluidField("signatureMethod")
    SignatureMethod<SignedInfoType<T>> withSignatureMethod();

    @net.vidageek.fluid.annotations.FluidField("reference")
    ReferenceType<SignedInfoType<T>> withReference();

    @net.vidageek.fluid.annotations.FluidField("id")
    SignedInfoType<T> withId(java.lang.String id);

}