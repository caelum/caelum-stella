package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeOperacao;

public final class VeiculoNovoImpl<T> implements VeiculoNovo<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.VeicProd veicProd;
    private final T parent;

    public VeiculoNovoImpl(final T parent) {
        this.parent = parent;
        veicProd = new br.com.caelum.stella.nfe.modelo.VeicProd();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.veicProd;
    }

    public VeiculoNovo<T> withTipoDeOperacao(final TipoDeOperacao string) {
        veicProd.setTpOp(string.getCode());
        return this;
    }

    public VeiculoNovo<T> withChassi(final String string) {
        veicProd.setChassi(string);
        return this;
    }

    public VeiculoNovo<T> withCodigoDaCor(final String string) {
        veicProd.setCCor(string);
        return this;
    }

    public VeiculoNovo<T> withDescricaoDaCor(final String string) {
        veicProd.setXCor(string);
        return this;
    }

    public VeiculoNovo<T> withPotenciaDoMotor(final String string) {
        veicProd.setPot(string);
        return this;
    }

    public VeiculoNovo<T> withCM3(final String string) {
        veicProd.setCM3(string);
        return this;
    }

    public VeiculoNovo<T> withPesoLiquido(final String string) {
        veicProd.setPesoL(string);
        return this;
    }

    public VeiculoNovo<T> withPesoBruto(final String string) {
        veicProd.setPesoB(string);
        return this;
    }

    public VeiculoNovo<T> withNumeroDeSerie(final String string) {
        veicProd.setNSerie(string);
        return this;
    }

    public VeiculoNovo<T> withTipoDeCombustivel(final String string) {
        veicProd.setTpComb(string);
        return this;
    }

    public VeiculoNovo<T> withNumeroDoMotor(final String string) {
        veicProd.setNMotor(string);
        return this;
    }

    public VeiculoNovo<T> withCMKG(final String string) {
        veicProd.setCMKG(string);
        return this;
    }

    public VeiculoNovo<T> withDistanciaEntreEixos(final String string) {
        veicProd.setDist(string);
        return this;
    }

    public VeiculoNovo<T> withRENAVAM(final String string) {
        veicProd.setRENAVAM(string);
        return this;
    }

    public VeiculoNovo<T> withAnoDoModelo(final String string) {
        veicProd.setAnoMod(string);
        return this;
    }

    public VeiculoNovo<T> withAnoDeFabricacao(final String string) {
        veicProd.setAnoFab(string);
        return this;
    }

    public VeiculoNovo<T> withTipoDePintura(final String string) {
        veicProd.setTpPint(string);
        return this;
    }

    public VeiculoNovo<T> withTipoDeVeiculo(final String string) {
        veicProd.setTpVeic(string);
        return this;
    }

    public VeiculoNovo<T> withEspecieDeVeiculo(final String string) {
        veicProd.setEspVeic(string);
        return this;
    }

    public VeiculoNovo<T> withVehicleIdentificationNumber(final String string) {
        veicProd.setVIN(string);
        return this;
    }

    public VeiculoNovo<T> withCondicaoDoVeiculo(final CondicaoDoVeiculo string) {
        veicProd.setCondVeic(string.getCode());
        return this;
    }

    public VeiculoNovo<T> withCodigoDaMarcaDoModelo(final String string) {
        veicProd.setCMod(string);
        return this;
    }
}