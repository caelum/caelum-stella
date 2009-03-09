package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoOperacao;

public final class VeicProdImpl implements VeicProd, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.VeicProd veicProd;

    public VeicProdImpl() {
        veicProd = new br.com.caelum.stella.nfe.modelo.VeicProd();
    }

    public br.com.caelum.stella.nfe.modelo.VeicProd getInstance() {
        return veicProd;
    }

    public VeicProd withTpOp(final TipoOperacao string) {
        veicProd.setTpOp(string.getCode());
        return this;
    }

    public VeicProd withChassi(final String string) {
        veicProd.setChassi(string);
        return this;
    }

    public VeicProd withCCor(final String string) {
        veicProd.setCCor(string);
        return this;
    }

    public VeicProd withXCor(final String string) {
        veicProd.setXCor(string);
        return this;
    }

    public VeicProd withPot(final String string) {
        veicProd.setPot(string);
        return this;
    }

    public VeicProd withCM3(final String string) {
        veicProd.setCM3(string);
        return this;
    }

    public VeicProd withPesoL(final String string) {
        veicProd.setPesoL(string);
        return this;
    }

    public VeicProd withPesoB(final String string) {
        veicProd.setPesoB(string);
        return this;
    }

    public VeicProd withNSerie(final String string) {
        veicProd.setNSerie(string);
        return this;
    }

    public VeicProd withTpComb(final String string) {
        veicProd.setTpComb(string);
        return this;
    }

    public VeicProd withNMotor(final String string) {
        veicProd.setNMotor(string);
        return this;
    }

    public VeicProd withCMKG(final String string) {
        veicProd.setCMKG(string);
        return this;
    }

    public VeicProd withDist(final String string) {
        veicProd.setDist(string);
        return this;
    }

    public VeicProd withRENAVAM(final String string) {
        veicProd.setRENAVAM(string);
        return this;
    }

    public VeicProd withAnoMod(final String string) {
        veicProd.setAnoMod(string);
        return this;
    }

    public VeicProd withAnoFab(final String string) {
        veicProd.setAnoFab(string);
        return this;
    }

    public VeicProd withTpPint(final String string) {
        veicProd.setTpPint(string);
        return this;
    }

    public VeicProd withTpVeic(final String string) {
        veicProd.setTpVeic(string);
        return this;
    }

    public VeicProd withEspVeic(final String string) {
        veicProd.setEspVeic(string);
        return this;
    }

    public VeicProd withVIN(final String string) {
        veicProd.setVIN(string);
        return this;
    }

    public VeicProd withCondVeic(final CondicaoDoVeiculo string) {
        veicProd.setCondVeic(string.getCode());
        return this;
    }

    public VeicProd withCMod(final String string) {
        veicProd.setCMod(string);
        return this;
    }
}