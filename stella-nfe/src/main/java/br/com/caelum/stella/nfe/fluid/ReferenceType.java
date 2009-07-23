package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ReferenceType.class)
public interface ReferenceType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("transforms")
    TransformsType<ReferenceType<T>> withTransforms();

    @net.vidageek.fluid.annotations.FluidField("digestMethod")
    DigestMethod<ReferenceType<T>> withDigestMethod();

    @net.vidageek.fluid.annotations.FluidField("digestValue")
    ReferenceType<T> withDigestValue(byte[] digestValue);

    @net.vidageek.fluid.annotations.FluidField("id")
    ReferenceType<T> withId(java.lang.String id);

    @net.vidageek.fluid.annotations.FluidField("uri")
    ReferenceType<T> withUri(java.lang.String uri);

    @net.vidageek.fluid.annotations.FluidField("type")
    ReferenceType<T> withType(java.lang.String type);

}