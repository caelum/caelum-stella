package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TEmissor.class)
public interface TEmissor<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("uf")
    TEmissor<T> withUf(br.com.caelum.stella.nfe.modelo.TUf uf);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    TEmissor<T> withCnpj(java.lang.String cnpj);

    @net.vidageek.fluid.annotations.FluidField("cnpjMatriz")
    TEmissor<T> withCnpjMatriz(java.lang.String cnpjMatriz);

    @net.vidageek.fluid.annotations.FluidField("ie")
    TEmissor<T> withIe(java.lang.String ie);

    @net.vidageek.fluid.annotations.FluidField("dFe")
    TEmissor<T> addDFe();

}