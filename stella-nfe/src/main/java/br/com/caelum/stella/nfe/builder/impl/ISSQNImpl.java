package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.ISSQN;

public class ISSQNImpl implements br.com.caelum.stella.nfe.builder.ISS, ObjectCreator {

    private final ISSQN issqn;

    public ISSQNImpl() {
        issqn = new ISSQN();
    }

    public ISSQNImpl withCodigoListaServicos(final int codigoListaServicos) {
        issqn.setCodigoListaServicos("" + codigoListaServicos);
        return this;
    }

    public ISSQNImpl withCodigoMunicipio(final int codigoMunicipio) {
        issqn.setCodigoMunicipio("" + codigoMunicipio);
        return this;
    }

    public ISSQNImpl withValor(final BigDecimal valor) {
        issqn.setValorISSQN(valor.toString());
        return this;
    }

    public ISSQNImpl withValorDaBaseDeCalculo(final BigDecimal valor) {
        issqn.setvalorDaBaseDeCalculo(valor.toString());
        return this;
    }

    public ISSQNImpl withAliquota(final BigDecimal aliquota) {
        issqn.setAliquota(aliquota.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) issqn;
    }

}
