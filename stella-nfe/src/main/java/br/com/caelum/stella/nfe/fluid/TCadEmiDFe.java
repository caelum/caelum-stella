package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TCadEmiDFe.class)
public interface TCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infCadEmiDFe")
    InfCadEmiDFe<TCadEmiDFe<T>> withInfCadEmiDFe();

    @net.vidageek.fluid.annotations.FluidField("signature")
    SignatureType<TCadEmiDFe<T>> withSignature();

    @net.vidageek.fluid.annotations.FluidField("versao")
    TCadEmiDFe<T> withVersao(java.lang.String versao);

}