package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.II;

public class IIImpl implements br.com.caelum.stella.nfe.builder.II, ObjectCreator {

    private final II ii;

    public IIImpl() {
        ii = new II();
    }

    public IIImpl withValorDaBaseDeCalculo(final BigDecimal valorDaBaseDeCalculo) {
        ii.setvalorDaBaseDeCalculo(valorDaBaseDeCalculo.toString());
        return this;
    }

    public IIImpl withValorII(final BigDecimal valorII) {
        ii.setValorImpostoImportacao(valorII.toString());
        return this;
    }

    public IIImpl withValorIOF(final BigDecimal valorIOF) {
        ii.setValorImpostoSobreOperacoesFinanceiras(valorIOF.toString());
        return this;
    }

    public IIImpl withValorAduaneira(final BigDecimal valorAduaneira) {
        ii.setValorDespesaAduaneira(valorAduaneira.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) ii;
    }

}