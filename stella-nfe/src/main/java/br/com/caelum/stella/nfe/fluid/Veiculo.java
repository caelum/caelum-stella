package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TVeiculo.class)
public interface Veiculo<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("placa")
    Veiculo<T> withPlaca(java.lang.String placa);

    @net.vidageek.fluid.annotations.FluidField("uf")
    Veiculo<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

    @net.vidageek.fluid.annotations.FluidField("rntc")
    Veiculo<T> withRegistroNacionalDoTransportadorDeCarga(java.lang.String registroNacionalDoTransportadorDeCarga);

}