package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe.class)
public interface InfAtuCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("uf")
    InfAtuCadEmiDFe<T> withUf(br.com.caelum.stella.nfe.modelo.TUf uf);

    @net.vidageek.fluid.annotations.FluidField("inclui")
    TEmissor<InfAtuCadEmiDFe<T>> withInclui();

    @net.vidageek.fluid.annotations.FluidField("exclui")
    Exclui<InfAtuCadEmiDFe<T>> withExclui();

    @net.vidageek.fluid.annotations.FluidField("id")
    InfAtuCadEmiDFe<T> withId(java.lang.String id);

}