package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe.class)
public interface TRetAtuCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infRetAtuCadEmiDFe")
    InfRetAtuCadEmiDFe<TRetAtuCadEmiDFe<T>> withInfRetAtuCadEmiDFe();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TRetAtuCadEmiDFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TRetAtuCadEmiDFe<T> withVersao(java.lang.String versao);

}