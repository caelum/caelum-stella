package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Transp.class)
public interface Transporte<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("modFrete")
    Transporte<T> withModalidadeDoFrete(java.lang.String modalidadeDoFrete);

    @net.vidageek.fluid.annotations.FluidField("transporta")
    transportador<Transporte<T>> withTransportador();

    @net.vidageek.fluid.annotations.FluidField("retTransp")
    ICMSRetidoPeloTransporte<Transporte<T>> withICMSRetidoPeloTransporte();

    @net.vidageek.fluid.annotations.FluidField("veicTransp")
    Veiculo<Transporte<T>> withVeiculoUsado();

    @net.vidageek.fluid.annotations.FluidField("reboque")
    Transporte<T> addReboque();

    @net.vidageek.fluid.annotations.FluidField("vol")
    Transporte<T> addVolume();

}