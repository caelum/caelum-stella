package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Med.class)
public interface Medicamento<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nLote")
    Medicamento<T> withNumeroDoLote(java.lang.String numeroDoLote);

    @net.vidageek.fluid.annotations.FluidField("qLote")
    Medicamento<T> withQuantidadeDoLote(java.lang.String quantidadeDoLote);

    @net.vidageek.fluid.annotations.FluidField("dFab")
    Medicamento<T> withDataDeFabricacao(java.util.Calendar dataDeFabricacao);

    @net.vidageek.fluid.annotations.FluidField("dVal")
    Medicamento<T> withDataDeValidade(java.util.Calendar dataDeValidade);

    @net.vidageek.fluid.annotations.FluidField("vpmc")
    Medicamento<T> withPrecoMaximoAoConsumidor(java.math.BigDecimal precoMaximoAoConsumidor);

}