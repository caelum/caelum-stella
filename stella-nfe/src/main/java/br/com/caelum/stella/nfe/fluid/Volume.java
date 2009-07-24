package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Vol.class)
public interface Volume<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("qVol")
    Volume<T> withQuantidade(java.lang.String quantidade);

    @net.vidageek.fluid.annotations.FluidField("esp")
    Volume<T> withEspecie(java.lang.String especie);

    @net.vidageek.fluid.annotations.FluidField("marca")
    Volume<T> withMarca(java.lang.String marca);

    @net.vidageek.fluid.annotations.FluidField("nVol")
    Volume<T> withNumeracao(java.lang.String numeracao);

    @net.vidageek.fluid.annotations.FluidField("pesoL")
    Volume<T> withPesoLiquido(java.lang.String pesoLiquido);

    @net.vidageek.fluid.annotations.FluidField("pesoB")
    Volume<T> withPesoBruto(java.lang.String pesoBruto);

    @net.vidageek.fluid.annotations.FluidField("lacres")
    Lacres<Volume<T>> addLacres();

}