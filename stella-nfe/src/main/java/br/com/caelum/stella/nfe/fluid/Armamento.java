package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Arma.class)
public interface Armamento<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpArma")
    Armamento<T> withTipo(br.com.caelum.stella.nfe.builder.enums.TipoDeArmamento tipo);

    @net.vidageek.fluid.annotations.FluidField("nSerie")
    Armamento<T> withNumeroDeSerie(java.lang.Integer numeroDeSerie);

    @net.vidageek.fluid.annotations.FluidField("nCano")
    Armamento<T> withNumeroDeSerieDoCano(java.lang.Integer numeroDeSerieDoCano);

    @net.vidageek.fluid.annotations.FluidField("descr")
    Armamento<T> withDescricao(java.lang.String descricao);

}