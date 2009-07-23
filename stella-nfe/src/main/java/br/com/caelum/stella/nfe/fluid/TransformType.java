package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TransformType.class)
public interface TransformType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("xPath")
    TransformType<T> addXPath(java.lang.String xPath);

    @net.vidageek.fluid.annotations.FluidField("algorithm")
    TransformType<T> withAlgorithm(java.lang.String algorithm);

}