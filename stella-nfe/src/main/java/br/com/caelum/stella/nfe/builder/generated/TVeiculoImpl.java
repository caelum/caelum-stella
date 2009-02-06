package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TVeiculoImpl implements TVeiculo, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TVeiculo tVeiculo;

    public TVeiculoImpl() {
        this.tVeiculo = new br.com.caelum.stella.nfe.modelo.TVeiculo();
    }

    public br.com.caelum.stella.nfe.modelo.TVeiculo getInstance() {
        return this.tVeiculo;
    }

    public TVeiculo withPlaca(String string) {
        this.tVeiculo.setPlaca(string);
        return this;
    }

    public TVeiculo withUF(TUf tUf) {
        this.tVeiculo.setUF(tUf);
        return this;
    }

    public TVeiculo withRNTC(String string) {
        this.tVeiculo.setRNTC(string);
        return this;
    }
}