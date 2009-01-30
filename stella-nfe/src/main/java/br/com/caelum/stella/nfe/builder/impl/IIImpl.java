package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.II;

public class IIImpl implements br.com.caelum.stella.nfe.builder.II, ObjectCreator {

    private II ii;

    public IIImpl() {
        ii = new II();
    }

    public IIImpl withValorBaseCalculo(BigDecimal valorBaseCalculo) {
        ii.setValorBaseCalculo(valorBaseCalculo.toString());
        return this;
    }

    public IIImpl withValorII(BigDecimal valorII) {
        ii.setValorImpostoImportacao(valorII.toString());
        return this;
    }

    public IIImpl withValorIOF(BigDecimal valorIOF) {
        ii.setValorImpostoSobreOperacoesFinanceiras(valorIOF.toString());
        return this;
    }

    public IIImpl withValorAduaneira(BigDecimal valorAduaneira) {
        ii.setValorDespesaAduaneira(valorAduaneira.toString());
        return this;
    }
    
    public Object getInstance() {
        return ii;
    }

}