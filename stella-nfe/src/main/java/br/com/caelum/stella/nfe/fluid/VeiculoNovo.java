package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.VeicProd.class)
public interface VeiculoNovo<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpOp")
    VeiculoNovo<T> withTipoDeOperacao(java.lang.String tipoDeOperacao);

    @net.vidageek.fluid.annotations.FluidField("chassi")
    VeiculoNovo<T> withChassi(java.lang.String chassi);

    @net.vidageek.fluid.annotations.FluidField("cCor")
    VeiculoNovo<T> withCodigoDaCor(java.lang.String codigoDaCor);

    @net.vidageek.fluid.annotations.FluidField("xCor")
    VeiculoNovo<T> withDescricaoDaCor(java.lang.String descricaoDaCor);

    @net.vidageek.fluid.annotations.FluidField("pot")
    VeiculoNovo<T> withPotenciaDoMotor(java.lang.String potenciaDoMotor);

    @net.vidageek.fluid.annotations.FluidField("cm3")
    VeiculoNovo<T> withCM3(java.lang.String CM3);

    @net.vidageek.fluid.annotations.FluidField("pesoL")
    VeiculoNovo<T> withPesoLiquido(java.lang.String pesoLiquido);

    @net.vidageek.fluid.annotations.FluidField("pesoB")
    VeiculoNovo<T> withPesoBruto(java.lang.String pesoBruto);

    @net.vidageek.fluid.annotations.FluidField("nSerie")
    VeiculoNovo<T> withNumeroDeSerie(java.lang.String numeroDeSerie);

    @net.vidageek.fluid.annotations.FluidField("tpComb")
    VeiculoNovo<T> withTipoDeCombustivel(java.lang.String tipoDeCombustivel);

    @net.vidageek.fluid.annotations.FluidField("nMotor")
    VeiculoNovo<T> withNumeroDoMotor(java.lang.String numeroDoMotor);

    @net.vidageek.fluid.annotations.FluidField("cmkg")
    VeiculoNovo<T> withCMKG(java.lang.String CMKG);

    @net.vidageek.fluid.annotations.FluidField("dist")
    VeiculoNovo<T> withDistanciaEntreEixos(java.lang.String distanciaEntreEixos);

    @net.vidageek.fluid.annotations.FluidField("renavam")
    VeiculoNovo<T> withRENAVAM(java.lang.String RENAVAM);

    @net.vidageek.fluid.annotations.FluidField("anoMod")
    VeiculoNovo<T> withAnoDoModelo(java.lang.String anoDoModelo);

    @net.vidageek.fluid.annotations.FluidField("anoFab")
    VeiculoNovo<T> withAnoDeFabricacao(java.lang.String anoDeFabricacao);

    @net.vidageek.fluid.annotations.FluidField("tpPint")
    VeiculoNovo<T> withTipoDePintura(java.lang.String tipoDePintura);

    @net.vidageek.fluid.annotations.FluidField("tpVeic")
    VeiculoNovo<T> withTipoDeVeiculo(java.lang.String tipoDeVeiculo);

    @net.vidageek.fluid.annotations.FluidField("espVeic")
    VeiculoNovo<T> withEspecieDeVeiculo(java.lang.String especieDeVeiculo);

    @net.vidageek.fluid.annotations.FluidField("vin")
    VeiculoNovo<T> withVehicleIdentificationNumber(java.lang.String vehicleIdentificationNumber);

    @net.vidageek.fluid.annotations.FluidField("condVeic")
    VeiculoNovo<T> withCondicaoDoVeiculo(java.lang.String condicaoDoVeiculo);

    @net.vidageek.fluid.annotations.FluidField("cMod")
    VeiculoNovo<T> withCodigoDaMarcaDoModelo(java.lang.String codigoDaMarcaDoModelo);

}