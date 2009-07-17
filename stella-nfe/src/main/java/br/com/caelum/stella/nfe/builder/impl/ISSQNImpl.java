package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.ISSQN;

public class ISSQNImpl<T> implements br.com.caelum.stella.nfe.builder.ISS<T>, ObjectCreator {

    private final ISSQN issqn;
    private final T parent;

    public ISSQNImpl(final T parent) {
        this.parent = parent;
        issqn = new ISSQN();
    }

    public T build() {
        return parent;
    }

    public ISSQNImpl<T> withCodigoListaServicos(final int codigoListaServicos) {
        issqn.setCodigoListaServicos("" + codigoListaServicos);
        return this;
    }

    public ISSQNImpl<T> withCodigoMunicipio(final int codigoMunicipio) {
        issqn.setCodigoMunicipio("" + codigoMunicipio);
        return this;
    }

    public ISSQNImpl<T> withValor(final BigDecimal valor) {
        issqn.setValorISSQN(valor.toString());
        return this;
    }

    public ISSQNImpl<T> withValorDaBaseDeCalculo(final BigDecimal valor) {
        issqn.setvalorDaBaseDeCalculo(valor.toString());
        return this;
    }

    public ISSQNImpl<T> withAliquota(final BigDecimal aliquota) {
        issqn.setAliquota(aliquota.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) issqn;
    }

}
