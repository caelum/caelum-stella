package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfCadEmiDFe.class)
public interface InfCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("dPubCad")
    InfCadEmiDFe<T> withDPubCad(java.lang.String dPubCad);

    @net.vidageek.fluid.annotations.FluidField("emissor")
    InfCadEmiDFe<T> addEmissor();

    @net.vidageek.fluid.annotations.FluidField("id")
    InfCadEmiDFe<T> withId(java.lang.String id);

}