package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.ISSQN;


public class ISSQNImpl implements br.com.caelum.stella.nfe.builder.ISS, ObjectCreator{

    private ISSQN issqn;

    public ISSQNImpl() {
        issqn = new ISSQN();
    }
    
    public ISSQNImpl withCodigoListaServicos(int codigoListaServicos) {
        issqn.setCodigoListaServicos("" + codigoListaServicos);
        return this;
    }

    public ISSQNImpl withCodigoMunicipio(int codigoMunicipio) {
        issqn.setCodigoMunicipio("" + codigoMunicipio);
        return this;
    }

    public ISSQNImpl withValor(BigDecimal valor) {
        issqn.setValorISSQN(valor.toString());
        return this;
    }

    public ISSQNImpl withValorBaseCalculo(BigDecimal valor) {
        issqn.setValorBaseCalculo(valor.toString());
        return this;
    }

    public ISSQNImpl withAliquota(BigDecimal aliquota) {
        issqn.setAliquota(aliquota.toString());
        return this;
    }

    public Object getInstance() {
        return issqn;
    }
    
}
