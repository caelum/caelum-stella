package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe.class)
public interface TAtuCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infAtuCadEmiDFe")
    InfAtuCadEmiDFe<TAtuCadEmiDFe<T>> withInfAtuCadEmiDFe();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TAtuCadEmiDFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TAtuCadEmiDFe<T> withVersao(java.lang.String versao);

}