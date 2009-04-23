package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrasOperacoesImpl implements PISOutrasOperacoes, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISOutr pISOutr;

    public PISOutrasOperacoesImpl() {
        pISOutr = new br.com.caelum.stella.nfe.modelo.PISOutr();
        pISOutr.setCST("99");
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.pISOutr;
    }

    public PISOutrasOperacoes withValorDaBaseDeCalculo(final BigDecimal string) {
        pISOutr.setVBC(string.toString());
        return this;
    }

    public PISOutrasOperacoes withAliquota(final BigDecimal string) {
        pISOutr.setPPIS(string.toString());
        return this;
    }

    public PISOutrasOperacoes withQuantidadeVendida(final BigDecimal string) {
        pISOutr.setQBCProd(string.toString());
        return this;
    }

    public PISOutrasOperacoes withAliquotaDoProduto(final BigDecimal string) {
        pISOutr.setVAliqProd(string.toString());
        return this;
    }

    public PISOutrasOperacoes withValor(final BigDecimal string) {
        pISOutr.setVPIS(string.toString());
        return this;
    }
}