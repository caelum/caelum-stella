package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class VeiculoImpl<T> implements Veiculo<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TVeiculo tVeiculo;
    private final T parent;

    public VeiculoImpl(final T parent) {
        this.parent = parent;
        tVeiculo = new br.com.caelum.stella.nfe.modelo.TVeiculo();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tVeiculo;
    }

    public Veiculo<T> withPlaca(final String string) {
        tVeiculo.setPlaca(string);
        return this;
    }

    public Veiculo<T> withUF(final UF tUf) {
        tVeiculo.setUF(tUf);
        return this;
    }

    public Veiculo<T> withRegistroNacionalDoTransportadorDeCarga(final String string) {
        tVeiculo.setRNTC(string);
        return this;
    }
}