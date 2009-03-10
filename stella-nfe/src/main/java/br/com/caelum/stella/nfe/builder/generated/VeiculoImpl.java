package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class VeiculoImpl implements Veiculo, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TVeiculo tVeiculo;

    public VeiculoImpl() {
        tVeiculo = new br.com.caelum.stella.nfe.modelo.TVeiculo();
    }

    public br.com.caelum.stella.nfe.modelo.TVeiculo getInstance() {
        return tVeiculo;
    }

    public Veiculo withPlaca(final String string) {
        tVeiculo.setPlaca(string);
        return this;
    }

    public Veiculo withUF(final UF tUf) {
        tVeiculo.setUF(tUf);
        return this;
    }

    public Veiculo withRegistroNacionalDoTransportadorDeCarga(final String string) {
        tVeiculo.setRNTC(string);
        return this;
    }
}