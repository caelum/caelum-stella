package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe.class)
public interface InfRetAtuCadEmiDFe<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("uf")
    InfRetAtuCadEmiDFe<T> withUf(br.com.caelum.stella.nfe.modelo.TUf uf);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    InfRetAtuCadEmiDFe<T> withCnpj(br.com.caelum.stella.tinytype.CNPJ cnpj);

    @net.vidageek.fluid.annotations.FluidField("ope")
    InfRetAtuCadEmiDFe<T> withOpe(java.lang.String ope);

    @net.vidageek.fluid.annotations.FluidField("resOpe")
    InfRetAtuCadEmiDFe<T> withResOpe(java.lang.String resOpe);

    @net.vidageek.fluid.annotations.FluidField("id")
    InfRetAtuCadEmiDFe<T> withId(java.lang.String id);

}