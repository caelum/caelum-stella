package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeOperacao;

public final class VeiculoNovoImpl implements VeiculoNovo, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.VeicProd veicProd;

    public VeiculoNovoImpl() {
        veicProd = new br.com.caelum.stella.nfe.modelo.VeicProd();
    }

    public br.com.caelum.stella.nfe.modelo.VeicProd getInstance() {
        return veicProd;
    }

    public VeiculoNovo withTipoDeOperacao(final TipoDeOperacao string) {
        veicProd.setTpOp(string.getCode());
        return this;
    }

    public VeiculoNovo withChassi(final String string) {
        veicProd.setChassi(string);
        return this;
    }

    public VeiculoNovo withCodigoDaCor(final String string) {
        veicProd.setCCor(string);
        return this;
    }

    public VeiculoNovo withDescricaoDaCor(final String string) {
        veicProd.setXCor(string);
        return this;
    }

    public VeiculoNovo withPotenciaDoMotor(final String string) {
        veicProd.setPot(string);
        return this;
    }

    public VeiculoNovo withCM3(final String string) {
        veicProd.setCM3(string);
        return this;
    }

    public VeiculoNovo withPesoLiquido(final String string) {
        veicProd.setPesoL(string);
        return this;
    }

    public VeiculoNovo withPesoBruto(final String string) {
        veicProd.setPesoB(string);
        return this;
    }

    public VeiculoNovo withNumeroDeSerie(final String string) {
        veicProd.setNSerie(string);
        return this;
    }

    public VeiculoNovo withTipoDeCombustivel(final String string) {
        veicProd.setTpComb(string);
        return this;
    }

    public VeiculoNovo withNumeroDoMotor(final String string) {
        veicProd.setNMotor(string);
        return this;
    }

    public VeiculoNovo withCMKG(final String string) {
        veicProd.setCMKG(string);
        return this;
    }

    public VeiculoNovo withDistanciaEntreEixos(final String string) {
        veicProd.setDist(string);
        return this;
    }

    public VeiculoNovo withRENAVAM(final String string) {
        veicProd.setRENAVAM(string);
        return this;
    }

    public VeiculoNovo withAnoDoModelo(final String string) {
        veicProd.setAnoMod(string);
        return this;
    }

    public VeiculoNovo withAnoDeFabricacao(final String string) {
        veicProd.setAnoFab(string);
        return this;
    }

    public VeiculoNovo withTipoDePintura(final String string) {
        veicProd.setTpPint(string);
        return this;
    }

    public VeiculoNovo withTipoDeVeiculo(final String string) {
        veicProd.setTpVeic(string);
        return this;
    }

    public VeiculoNovo withEspecieDeVeiculo(final String string) {
        veicProd.setEspVeic(string);
        return this;
    }

    public VeiculoNovo withVehicleIdentificationNumber(final String string) {
        veicProd.setVIN(string);
        return this;
    }

    public VeiculoNovo withCondicaoDoVeiculo(final CondicaoDoVeiculo string) {
        veicProd.setCondVeic(string.getCode());
        return this;
    }

    public VeiculoNovo withCodigoDaMarcaDoModelo(final String string) {
        veicProd.setCMod(string);
        return this;
    }
}