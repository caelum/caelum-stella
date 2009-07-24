package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TransformsType.class)
public interface TransformsType<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("transform")
    TransformType<TransformsType<T>> addTransform();

}